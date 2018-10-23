package com.steve.service;

import com.steve.model.Recruitment;

import java.util.List;

public interface RecruitmentService {
    List<Recruitment> getAllRecruitments();

    Recruitment getRecruitmentById(Integer rec_id);
}
