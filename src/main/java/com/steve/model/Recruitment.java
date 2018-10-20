package com.steve.model;

import java.util.Date;

public class Recruitment {
    private Integer recru_id;
    private Position position;
    private Date recru_time;


    public Recruitment() {
    }

    public Recruitment(Position position, Date recru_time) {
        this.position = position;
        this.recru_time = recru_time;
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
