package com.steve.dao;

import com.steve.model.Resume;
import org.springframework.stereotype.Repository;

@Repository
public interface ResumeDao {
    void saveResume(Resume resume);
}
