package com.steve.model;

public class Position {
    private Integer p_id;
    private String p_name;
    private String p_require;
    private String p_description;
    private Double p_salary;
    private Department department;


    public Position() {
    }

    public Position(String p_name, String p_require, String p_description, Double p_salary, Department department) {
        this.p_name = p_name;
        this.p_require = p_require;
        this.p_description = p_description;
        this.p_salary = p_salary;
        this.department = department;
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

    public String getP_require() {
        return p_require;
    }

    public void setP_require(String p_require) {
        this.p_require = p_require;
    }

    public String getP_description() {
        return p_description;
    }

    public void setP_description(String p_description) {
        this.p_description = p_description;
    }

    public Double getP_salary() {
        return p_salary;
    }

    public void setP_salary(Double p_salary) {
        this.p_salary = p_salary;
    }
}
