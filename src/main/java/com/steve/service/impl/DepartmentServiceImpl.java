package com.steve.service.impl;

import com.steve.dao.DepartmentDao;
import com.steve.model.Department;
import com.steve.service.DepartmentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;


@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Resource
    private DepartmentDao departmentDao;
    /*
        记住之后要添加重名判断
     */
    @Override
    public boolean saveDepartment(String department_name) {

        Department department = new Department();
        department.setDep_name(department_name);
        department.setDep_create_time(new Date());

        departmentDao.saveDepartment(department);
        return true;
    }

    @Override
    public Department getDepartmentByName(String depart_name) {
        return departmentDao.getDepartmentByName(depart_name);
    }
}
