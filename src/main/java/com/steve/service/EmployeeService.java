package com.steve.service;

import com.steve.model.Employee;

import java.util.List;

public interface EmployeeService {

    boolean saveEmployee(Employee employee);

    List<Employee> getEmployeeByPos(Integer selected);

    List<Employee> getAllEmployee();

    Employee getEmployeeByEmpId(Integer emp_id);
}
