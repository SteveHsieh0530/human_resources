package com.steve.service.impl;

import com.steve.dao.AttendanceDao;
import com.steve.dao.EmployeeDao;
import com.steve.model.Attendance;
import com.steve.model.Employee;
import com.steve.service.AttendanceService;
import com.steve.service.EmployeeService;
import com.steve.service.SalaryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
public class SalaryServiceImpl implements SalaryService {
    @Resource
    private EmployeeDao employeeDao;

    @Resource
    private AttendanceDao attendanceDao;

    @Override
    public boolean generateLastMonthSalary() {
        //先查出全部还在职员工
        List<Employee> employees = employeeDao.getEmployeeNotLeaving();

        //得到上个月的月份
        Calendar calendar = Calendar.getInstance();
        int monthInt = calendar.get(Calendar.MONTH) + 1;    //得到上个月的月份
        String month = "" + monthInt;

        //循环遍历用员工id, 以及上个月的时间 去查找考勤记录
        for (Employee employee : employees) {
            HashMap<String, Object> hashMap = new HashMap<String, Object>();

            hashMap.put("emp_id", employee.getEmp_id());
            hashMap.put("month", month);

            //每个循环得出有多少条考勤记录
            List<Attendance> attendances = attendanceDao.getAttendanceByMonthAndEmpId(hashMap);

            //考勤记录一共多少条
            int attCount = attendances.size();

            //如果少于22个工作室
            if(attCount < 22){

            }


        }




        return false;
    }
}
