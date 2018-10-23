package com.steve.dao;

import com.steve.model.Interview;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InterviewDao {
    void saveInterview(Interview interview);

    List<Interview> getInterviewByGuestID(Integer g_id);

    Interview getInterviewById(Integer inter_id);

    void updateInterview(Interview interview);
}
