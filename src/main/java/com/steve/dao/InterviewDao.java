package com.steve.dao;

import com.steve.model.Interview;
import org.springframework.stereotype.Repository;

@Repository
public interface InterviewDao {
    void saveInterview(Interview interview);
}
