package com.steve.model;

import java.io.Serializable;
import java.util.Date;

public class Salary implements Serializable {
    private Integer s_id;
    private Date s_month;
    private Date s_salary;
    private Employee employee;

    public Integer getS_id() {
        return s_id;
    }

    public void setS_id(Integer s_id) {
        this.s_id = s_id;
    }

    public Date getS_month() {
        return s_month;
    }

    public void setS_month(Date s_month) {
        this.s_month = s_month;
    }

    public Date getS_salary() {
        return s_salary;
    }

    public void setS_salary(Date s_salary) {
        this.s_salary = s_salary;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
