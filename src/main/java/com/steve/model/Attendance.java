package com.steve.model;

import java.io.Serializable;
import java.util.Date;

public class Attendance implements Serializable {
    private Integer A_ID;
    private Date A_IN_TIME;
    private Date A_OUT_TIME;
    private Employee employee;

    public Attendance() {
    }

    public Integer getA_ID() {
        return A_ID;
    }

    public void setA_ID(Integer a_ID) {
        A_ID = a_ID;
    }

    public Date getA_IN_TIME() {
        return A_IN_TIME;
    }

    public void setA_IN_TIME(Date a_IN_TIME) {
        A_IN_TIME = a_IN_TIME;
    }

    public Date getA_OUT_TIME() {
        return A_OUT_TIME;
    }

    public void setA_OUT_TIME(Date a_OUT_TIME) {
        A_OUT_TIME = a_OUT_TIME;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
