package com.steve.service.impl;

import com.steve.dao.DepartmentDao;
import com.steve.dao.EmployeeDao;
import com.steve.dao.PositionDao;
import com.steve.dao.ResumeDao;
import com.steve.model.Department;
import com.steve.model.Employee;
import com.steve.model.Position;
import com.steve.service.DepartmentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;


@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Resource
    private DepartmentDao departmentDao;
    @Resource
    private PositionDao positionDao;
    @Resource
    private EmployeeDao employeeDao;
    /*
        记住之后要添加重名判断
     */
    @Override
    public boolean saveDepartment(String department_name) {
        List<Department> departments = departmentDao.getAllDepartments();
        //判断是否重名
        for(int i = 0 ; i < departments.size(); i++){
            String dep_name = departments.get(i).getDep_name();
            if(dep_name.equals(department_name)){
                return false;
            }
        }
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

    @Override
    public List<Department> getAllDepartments() {

        return departmentDao.getAllDepartments();
    }

    @Override
    public boolean updateDepartment(Department department) {

        //判断是否重名
        List<Department> departments = departmentDao.getAllDepartments();
        for(int i = 0 ; i < departments.size(); i++){
            String dep_name = departments.get(i).getDep_name();
            if(dep_name.equals(department.getDep_name())){
                return false;
            }
        }

        //可能以后要修改，直接用参数少一次数据库访问
        Department theDepartment = departmentDao.getDepartmentById( department.getDep_id());
        theDepartment.setDep_name(department.getDep_name());
        departmentDao.updateDepartment(theDepartment);
        return true;
    }

    @Override
    public boolean deleteDepartment(Integer dep_id) {
        List<Employee> employees = employeeDao.getEmployeeByDepId(dep_id);
        if(employees.size() > 0){
            return false;
        }
        departmentDao.deleteDepartment(dep_id);
        return true;
    }

    @Override
    public List<Department> getDepartmentsNotIncludeEmpId(Integer emp_id) {
        return departmentDao.getDepartmentsNotIncludeEmpId(emp_id);
    }
}
