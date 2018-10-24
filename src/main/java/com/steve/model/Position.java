package com.steve.model;

public class Position {
    private Integer p_id;
    private String p_name;
    private Double p_salary;
    private Department department;


    public Position() {
    }


    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Integer getP_id() {
        return p_id;
    }

    public void setP_id(Integer p_id) {
        this.p_id = p_id;
    }

    public String getP_name() {
        return p_name;
    }

    public void setP_name(String p_name) {
        this.p_name = p_name;
    }

    public Double getP_salary() {
        return p_salary;
    }

    public void setP_salary(Double p_salary) {
        this.p_salary = p_salary;
    }
}
