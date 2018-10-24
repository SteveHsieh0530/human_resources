package com.steve.service.impl;

import com.steve.dao.EmployeeDao;
import com.steve.model.Employee;
import com.steve.service.EmployeeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Resource
    private EmployeeDao employeeDao;
    @Override
    public boolean saveEmployee(Employee employee) {
        employeeDao.saveEmployee(employee);
        return false;
    }
}
