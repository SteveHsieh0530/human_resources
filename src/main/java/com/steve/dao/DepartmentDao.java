package com.steve.dao;

import com.steve.model.Department;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentDao {

    void saveDepartment(Department department);

    Department getDepartmentByName(String depart_name);

    List<Department> getAllDepartments();

    void updateDepartment(Department department);

    Department getDepartmentById(Integer dep_id);

    void deleteDepartment(Integer dep_id);

    List<Department> getDepartmentsNotIncludeEmpId(Integer emp_id);
}
