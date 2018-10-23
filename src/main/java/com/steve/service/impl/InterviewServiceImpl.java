package com.steve.service.impl;

import com.steve.dao.InterviewDao;
import com.steve.model.Interview;
import com.steve.service.InterviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InterviewServiceImpl implements InterviewService {
    @Autowired
    private InterviewDao interviewDao;


    @Override
    public void saveInterview(Interview interview) {
        interview.setI_status(1);   //测试用！！！！！！！！！
        interviewDao.saveInterview(interview);
    }

    @Override
    public List<Interview> getInterviewByGuestId(Integer g_id) {

        return interviewDao.getInterviewByGuestID(g_id);
    }

    @Override
    public Interview getInterviewById(Integer inter_id) {

        return interviewDao.getInterviewById(inter_id);
    }

    @Override
    public void updateInterview(Interview interview) {
        interviewDao.updateInterview(interview);
    }
}
