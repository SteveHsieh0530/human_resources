package com.steve.service.impl;

import com.steve.dao.RecruitmentDao;
import com.steve.model.Recruitment;
import com.steve.service.RecruitmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecruitmentServiceImpl implements RecruitmentService {
    @Autowired
    private RecruitmentDao recruitmentDao;

    @Override
    public List<Recruitment> getAllRecruitments() {
        return recruitmentDao.getALLRecruitments();
    }

    @Override
    public Recruitment getRecruitmentById(Integer rec_id) {
        return recruitmentDao.getRecruitmentById(rec_id);
    }
}
