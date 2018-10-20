package com.steve.model;

import java.util.Date;

public class Interview {
    private Integer i_id;
    private Resume resume;
    private Recruitment recruitment;
    private Date i_send_time;
    private Date i_invite_time;
    private Integer i_status;


    public Interview() {
    }

    public Interview(Resume resume, Recruitment recruitment, Date i_send_time, Date i_invite_time, Integer i_status) {
        this.resume = resume;
        this.recruitment = recruitment;
        this.i_send_time = i_send_time;
        this.i_invite_time = i_invite_time;
        this.i_status = i_status;
    }

    public Integer getI_id() {
        return i_id;
    }

    public void setI_id(Integer i_id) {
        this.i_id = i_id;
    }

    public Resume getResume() {
        return resume;
    }

    public void setResume(Resume resume) {
        this.resume = resume;
    }

    public Recruitment getRecruitment() {
        return recruitment;
    }

    public void setRecruitment(Recruitment recruitment) {
        this.recruitment = recruitment;
    }

    public Date getI_send_time() {
        return i_send_time;
    }

    public void setI_send_time(Date i_send_time) {
        this.i_send_time = i_send_time;
    }

    public Date getI_invite_time() {
        return i_invite_time;
    }

    public void setI_invite_time(Date i_invite_time) {
        this.i_invite_time = i_invite_time;
    }

    public Integer getI_status() {
        return i_status;
    }

    public void setI_status(Integer i_status) {
        this.i_status = i_status;
    }
}
