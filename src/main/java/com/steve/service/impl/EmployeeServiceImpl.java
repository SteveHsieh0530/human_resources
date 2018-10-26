package com.steve.service.impl;

import com.steve.dao.EmployeeDao;
import com.steve.dao.PositionDao;
import com.steve.model.Employee;
import com.steve.model.Position;
import com.steve.service.EmployeeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Resource
    private EmployeeDao employeeDao;
    @Resource
    private PositionDao positionDao;

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


    /*
        暂时没有逻辑判断
     */
    @Override
    public boolean updateEmpByAdmin(Integer emp_id, Integer emp_status, Integer emp_pos_id) {
        Employee employee = employeeDao.getEmployeeByEmpId(emp_id);
        employee.setEmp_status(emp_status);

        Position position =  positionDao.getPositionByPosId(emp_pos_id);
        employee.setPosition(position);
        employeeDao.updateEmployee(employee);
        return true;
    }


}
