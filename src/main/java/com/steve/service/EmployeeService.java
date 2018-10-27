package com.steve.service;

import com.steve.model.Employee;

import java.util.List;

public interface EmployeeService {

    boolean saveEmployee(Employee employee);

    List<Employee> getEmployeeByPos(Integer selected);

    List<Employee> getAllEmployee();

    Employee getEmployeeByEmpId(Integer emp_id);

    /*
        管理员用的更新员工方法，只能更新员工在职状态以及职位
     */
    boolean updateEmpByAdmin(Integer emp_id, Integer emp_status, Integer emp_pos_id);

    Employee login(String acc, String pass);

}
