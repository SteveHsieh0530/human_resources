package com.steve.service;

import com.steve.model.Department;

public interface DepartmentService {
    boolean saveDepartment(String department_name);

    Department getDepartmentByName(String depart_name);
}
