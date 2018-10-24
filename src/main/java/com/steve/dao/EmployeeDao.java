package com.steve.dao;

import com.steve.model.Employee;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeDao {

    void saveEmployee(Employee employee);
}
