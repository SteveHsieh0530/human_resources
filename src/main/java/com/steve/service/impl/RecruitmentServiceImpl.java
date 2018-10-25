package com.steve.service.impl;

import com.steve.dao.PositionDao;
import com.steve.dao.RecruitmentDao;
import com.steve.model.Recruitment;
import com.steve.service.RecruitmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class RecruitmentServiceImpl implements RecruitmentService {
    @Autowired
    private RecruitmentDao recruitmentDao;
    @Autowired
    private PositionDao positionDao;

    @Override
    public List<Recruitment> getAllRecruitments() {
        return recruitmentDao.getALLRecruitments();
    }

    @Override
    public Recruitment getRecruitmentById(Integer rec_id) {
        return recruitmentDao.getRecruitmentById(rec_id);
    }

    @Override
    public boolean createRecruitment(Recruitment recruitment, String position_name) {
        recruitment.setPosition(positionDao.getPositionByName(position_name));
        recruitment.setRecru_time(new Date());
        return recruitmentDao.saveRecruitment(recruitment);
    }

    @Override
    public boolean updateRecruitment(Recruitment recruitment, String position_name) {
        recruitment.setPosition(positionDao.getPositionByName(position_name));
        recruitment.setRecru_time(new Date());
        return recruitmentDao.updateRecruitment(recruitment);
    }

    @Override
    public boolean deleteRecruitment(Integer recru_id) {

        return recruitmentDao.deleteRecruitment(recru_id);
    }
}
