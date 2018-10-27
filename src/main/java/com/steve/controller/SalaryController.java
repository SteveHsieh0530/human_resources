package com.steve.controller;

import com.steve.service.SalaryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
public class SalaryController {
    @Resource
    private SalaryService salaryService;
    @RequestMapping("/generateLastMonthSalary")
    public String generateLastMonthSalary (){
        salaryService.generateLastMonthSalary();
        return "";


    }
}
