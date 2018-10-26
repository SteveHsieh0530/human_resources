package com.steve.service.impl;

import com.steve.dao.EmployeeDao;
import com.steve.model.Employee;
import com.steve.service.EmployeeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Resource
    private EmployeeDao employeeDao;
    @Override
    public boolean saveEmployee(Employee employee) {
        employeeDao.saveEmployee(employee);
        return false;
    }

    @Override
    public List<Employee> getEmployeeByPos(Integer selected) {
        return employeeDao.getEmployeeByPos(selected);
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeDao.getAllEmployee();
    }

    @Override
    public Employee getEmployeeByEmpId(Integer emp_id) {
        return employeeDao.getEmployeeByEmpId(emp_id);
    }


}
