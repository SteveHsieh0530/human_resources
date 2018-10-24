package com.steve.dao;

import com.steve.model.Department;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentDao {

    void saveDepartment(Department department);

    Department getDepartmentByName(String depart_name);
}
