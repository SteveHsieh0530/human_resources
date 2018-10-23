package com.steve.service;

import com.steve.model.Interview;
import org.springframework.stereotype.Service;

import java.util.List;


public interface InterviewService {
    void saveInterview(Interview interview);
    List<Interview> getInterviewByGuestId(Integer g_id);

    Interview getInterviewById(Integer inter_id);

    void updateInterview(Interview interview);
}
