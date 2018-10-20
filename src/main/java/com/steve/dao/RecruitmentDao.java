package com.steve.dao;

import com.steve.model.Recruitment;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecruitmentDao {
    List<Recruitment> getALLRecruitments();
}
