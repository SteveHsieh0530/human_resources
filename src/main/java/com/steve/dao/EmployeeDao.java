package com.steve.dao;

import com.steve.model.Department;
import com.steve.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeDao {

    void saveEmployee(Employee employee);

    List<Employee> getEmployeeByDepId(Integer dep_id);

    List<Employee> getEmployeeByPos(Integer selected);

    List<Employee> getAllEmployee();

    Employee getEmployeeByEmpId(Integer emp_id);

    void updateEmployee(Employee employee);
}
