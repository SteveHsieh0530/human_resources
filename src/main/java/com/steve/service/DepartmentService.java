package com.steve.service;

import com.steve.model.Department;

import java.util.List;

public interface DepartmentService {
    boolean saveDepartment(String department_name);

    Department getDepartmentByName(String depart_name);

    List<Department> getAllDepartments();

    boolean updateDepartment(Department department);

    boolean deleteDepartment(Integer dep_id);

    List<Department> getDepartmentsNotIncludeEmpId(Integer emp_id);
}
