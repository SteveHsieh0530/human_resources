package com.steve.model;

import java.io.Serializable;

public class Resume implements Serializable {
    private Integer res_id;
    private Guest guest;
    private String res_name;
    private String res_gender;
    private String res_birth;
    private String res_education;
    private Integer res_height;
    private Integer res_weight;
    private String res_major;
    private String res_marriage;
    private String res_gra_school;
    private String res_idcard;
    private String res_experience;
    private String res_address;
    private String res_phone;



    public Resume() {
    }

    public Resume(Guest guest, String res_name, String res_gender, String res_birth, String res_education, Integer res_height, Integer res_weight, String res_major, String res_marriage, String res_gra_school, String res_idcard, String res_experience, String res_address, String res_phone) {
        this.guest = guest;
        this.res_name = res_name;
        this.res_gender = res_gender;
        this.res_birth = res_birth;
        this.res_education = res_education;
        this.res_height = res_height;
        this.res_weight = res_weight;
        this.res_major = res_major;
        this.res_marriage = res_marriage;
        this.res_gra_school = res_gra_school;
        this.res_idcard = res_idcard;
        this.res_experience = res_experience;
        this.res_address = res_address;
        this.res_phone = res_phone;
    }

    public Integer getRes_id() {
        return res_id;
    }

    public void setRes_id(Integer res_id) {
        this.res_id = res_id;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public String getRes_name() {
        return res_name;
    }

    public void setRes_name(String res_name) {
        this.res_name = res_name;
    }

    public String getRes_gender() {
        return res_gender;
    }

    public void setRes_gender(String res_gender) {
        this.res_gender = res_gender;
    }

    public String getRes_birth() {
        return res_birth;
    }

    public void setRes_birth(String res_birth) {
        this.res_birth = res_birth;
    }

    public String getRes_education() {
        return res_education;
    }

    public void setRes_education(String res_edducation) {
        this.res_education = res_edducation;
    }

    public Integer getRes_height() {
        return res_height;
    }

    public void setRes_height(Integer res_height) {
        this.res_height = res_height;
    }

    public Integer getRes_weight() {
        return res_weight;
    }

    public void setRes_weight(Integer res_weight) {
        this.res_weight = res_weight;
    }

    public String getRes_major() {
        return res_major;
    }

    public void setRes_major(String res_major) {
        this.res_major = res_major;
    }

    public String getRes_marriage() {
        return res_marriage;
    }

    public void setRes_marriage(String res_marriage) {
        this.res_marriage = res_marriage;
    }

    public String getRes_gra_school() {
        return res_gra_school;
    }

    public void setRes_gra_school(String res_gra_school) {
        this.res_gra_school = res_gra_school;
    }

    public String getRes_idcard() {
        return res_idcard;
    }

    public void setRes_idcard(String res_idcard) {
        this.res_idcard = res_idcard;
    }

    public String getRes_experience() {
        return res_experience;
    }

    public void setRes_experience(String res_experience) {
        this.res_experience = res_experience;
    }

    public String getRes_address() {
        return res_address;
    }

    public void setRes_address(String res_address) {
        this.res_address = res_address;
    }

    public String getRes_phone() {
        return res_phone;
    }

    public void setRes_phone(String res_phone) {
        this.res_phone = res_phone;
    }
}
