package com.steve.service.impl;

import com.steve.dao.AttendanceDao;
import com.steve.model.Attendance;
import com.steve.model.Employee;
import com.steve.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

@Service
public class AttendanceServiceImpl implements AttendanceService {
    @Autowired
    private AttendanceDao attendanceDao;

    private final String IN_TIME="09:00:00";
    private final String OUT_TIME="18:00:00";

    @Override
    public boolean clockInAndClockOut(Employee employee) {

        //先确定这个员工今天有没打过卡y
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(currentTime);
        String day = dateString.substring(8, 10);  //得到打卡时的day

        //用员工id以及今天日期去确认今天是否打过卡
        HashMap<String, Object> search = new HashMap<>();
        search.put("day", day);
        search.put("emp_id", employee.getEmp_id());
        Attendance attendance = attendanceDao.getAttendanceByDayAndEmp(search);

        //如果没打过卡, 打上班卡
        if(attendance == null){
            Attendance newAtt = new Attendance();
            newAtt.setA_in_time(currentTime);
            newAtt.setEmployee(employee);
            String todayIn_time = dateString.substring(0,11) + IN_TIME;
            try {
                Date aDate = formatter.parse(todayIn_time);
                long timeDiff = (currentTime.getTime()-aDate.getTime()) / 1000;
                //3小时有10800秒
                if(timeDiff > 10800){
                    newAtt.setA_status(2); //状态2为旷工
                }else if(timeDiff > 0){
                    newAtt.setA_status(1); //状态1为迟到或早退
                }else{
                    newAtt.setA_status(0); //正常
                }
                attendanceDao.saveAttendance(newAtt);
                return true;
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }else{
            //如果下班卡已经打过，那直接返回false，阻止这个操作
            if(attendance.getA_out_time() != null){
                return false;
            }
            //下班卡
            attendance.setA_out_time(currentTime);
            if(attendance.getA_status() == 2){  //已经旷工，下面不需要判断了，都是旷工
                attendanceDao.updateAttendance(attendance);
                return true;
            }
            //string格式的今天下班时间
            String todayOut_time = dateString.substring(0,11) + OUT_TIME;
            try {
                //得到date属性的下班时间
                Date todayOut_date = formatter.parse(todayOut_time);
                //得到下班时间-下班打卡时间的差值 (秒)
                long timeDiff = (todayOut_date.getTime() - currentTime.getTime()) / 1000;

                //上班时间正常，
                if(attendance.getA_status() == 0){
                    //早退超过3小时
                    if(timeDiff > 10800){
                        attendance.setA_status(2); //状态2为旷工
                    }else if(timeDiff > 0){
                        attendance.setA_status(1); //状态1为迟到或早退
                    }else{
                        System.out.println("test");
                        attendance.setA_status(0);
                    }
                    attendanceDao.updateAttendance(attendance);
                    return true;
                }
                //上班已迟到
                if(attendance.getA_status()==1){
                    //员工今天的上班时间-应当的上班时间 （秒）
                    long lateTime = (attendance.getA_in_time().getTime() - todayOut_date.getTime()) / 1000;
                    //如果晚打卡, 相差时间还是0
                    if(timeDiff < 0){
                        timeDiff = 0;
                    }
                    //上班迟到+下班早退超过3小时
                    if((lateTime+timeDiff)>10800){
                        attendance.setA_status(2);
                    }
                    //如果没超过3小时那保持原来的早退/迟到状态就好
                    attendanceDao.updateAttendance(attendance);
                    return true;
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }

        }
        return false;
    }
}
