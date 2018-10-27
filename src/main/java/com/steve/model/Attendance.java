package com.steve.model;

import java.io.Serializable;
import java.util.Date;

public class Attendance implements Serializable {
    private Integer a_id;
    private Date a_in_time;
    private Date a_out_time;
    private Employee employee;
    private Integer a_status;

    public Integer getA_id() {
        return a_id;
    }

    public void setA_id(Integer a_id) {
        this.a_id = a_id;
    }

    public Date getA_in_time() {
        return a_in_time;
    }

    public void setA_in_time(Date a_in_time) {
        this.a_in_time = a_in_time;
    }

    public Date getA_out_time() {
        return a_out_time;
    }

    public void setA_out_time(Date a_out_time) {
        this.a_out_time = a_out_time;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Integer getA_status() {
        return a_status;
    }

    public void setA_status(Integer a_status) {
        this.a_status = a_status;
    }
}
