package com.steve.model;

import java.io.Serializable;
import java.util.Date;

public class Department implements Serializable {
    private Integer dep_id;
    private String dep_name;
    private Date dep_create_time;


    public Department() {
    }

    public Date getDep_create_time() {
        return dep_create_time;
    }

    public void setDep_create_time(Date dep_create_time) {
        this.dep_create_time = dep_create_time;
    }

    public Department(String dep_name) {
        this.dep_name = dep_name;
    }

    public Integer getDep_id() {
        return dep_id;
    }

    public void setDep_id(Integer dep_id) {
        this.dep_id = dep_id;
    }

    public String getDep_name() {
        return dep_name;
    }

    public void setDep_name(String dep_name) {
        this.dep_name = dep_name;
    }
}
