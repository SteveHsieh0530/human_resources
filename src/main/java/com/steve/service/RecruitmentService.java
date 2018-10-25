package com.steve.service;

import com.steve.model.Recruitment;

import java.util.List;

public interface RecruitmentService {
    List<Recruitment> getAllRecruitments();

    Recruitment getRecruitmentById(Integer rec_id);

    boolean createRecruitment(Recruitment recruitment, String position_name);

    boolean updateRecruitment(Recruitment recruitment, String position_name);

    boolean deleteRecruitment(Integer recru_id);
}
