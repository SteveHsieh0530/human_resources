package com.steve.controller;

import com.steve.model.Employee;
import com.steve.service.AttendanceService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
public class AttendanceController {

    @Resource
    private AttendanceService attendanceService;

    @RequestMapping("/createAttendance")
    public String createAttendance (HttpSession session){
        Employee employee = (Employee) session.getAttribute("employee");
        boolean check = attendanceService.clockInAndClockOut(employee);
        return "";
    }
}
