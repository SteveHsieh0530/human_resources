package com.steve.dao;

import com.steve.model.Recruitment;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecruitmentDao {
    List<Recruitment> getALLRecruitments();

    Recruitment getRecruitmentById(Integer rec_id);

    boolean saveRecruitment(Recruitment recruitment);

    boolean updateRecruitment(Recruitment recruitment);

    boolean deleteRecruitment(Integer recru_id);
}
