package com.steve.model;

import java.io.Serializable;
import java.util.Date;

public class Employee implements Serializable {
    private Integer emp_id;
    private String emp_name;
    private String emp_pass;
    private String emp_gender;
    private String emp_birth;
    private String emp_address;
    private String emp_phone;
    private Double emp_salary;
    private Position position;
    private String emp_acc;
    private Integer emp_status;
    private Date emp_create_time;

    public Employee() {
    }

    public Date getEmp_create_time() {
        return emp_create_time;
    }

    public void setEmp_create_time(Date emp_create_time) {
        this.emp_create_time = emp_create_time;
    }

    public Integer getEmp_status() {
        return emp_status;
    }

    public void setEmp_status(Integer emp_status) {
        this.emp_status = emp_status;
    }

    public String getEmp_acc() {
        return emp_acc;
    }

    public void setEmp_acc(String emp_acc) {
        this.emp_acc = emp_acc;
    }

    public Integer getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(Integer emp_id) {
        this.emp_id = emp_id;
    }

    public String getEmp_name() {
        return emp_name;
    }

    public void setEmp_name(String emp_name) {
        this.emp_name = emp_name;
    }

    public String getEmp_pass() {
        return emp_pass;
    }

    public void setEmp_pass(String emp_pass) {
        this.emp_pass = emp_pass;
    }

    public String getEmp_gender() {
        return emp_gender;
    }

    public void setEmp_gender(String emp_gender) {
        this.emp_gender = emp_gender;
    }

    public String getEmp_birth() {
        return emp_birth;
    }

    public void setEmp_birth(String emp_birth) {
        this.emp_birth = emp_birth;
    }

    public String getEmp_address() {
        return emp_address;
    }

    public void setEmp_address(String emp_address) {
        this.emp_address = emp_address;
    }

    public String getEmp_phone() {
        return emp_phone;
    }

    public void setEmp_phone(String emp_phone) {
        this.emp_phone = emp_phone;
    }

    public Double getEmp_salary() {
        return emp_salary;
    }

    public void setEmp_salary(Double emp_salary) {
        this.emp_salary = emp_salary;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
