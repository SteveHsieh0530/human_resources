package com.steve.model;

import java.util.Date;

public class Recruitment {
    private Integer recru_id;
    private Position position;
    private String recru_description;
    private String recru_require;
    private Date recru_time;


    public Recruitment() {
    }

    public Recruitment(Position position, Date recru_time) {
        this.position = position;
        this.recru_time = recru_time;
    }

    public String getRecru_description() {
        return recru_description;
    }

    public void setRecru_description(String recru_description) {
        this.recru_description = recru_description;
    }

    public String getRecru_require() {
        return recru_require;
    }

    public void setRecru_require(String recru_require) {
        this.recru_require = recru_require;
    }

    public Integer getRecru_id() {
        return recru_id;
    }

    public void setRecru_id(Integer recru_id) {
        this.recru_id = recru_id;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Date getRecru_time() {
        return recru_time;
    }

    public void setRecru_time(Date recru_time) {
        this.recru_time = recru_time;
    }
}
