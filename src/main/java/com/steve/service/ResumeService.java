package com.steve.service;

import com.steve.model.Resume;


public interface ResumeService {
    boolean saveResume(Resume resume);
    Resume getResumeByGuestId(Integer guest_id);
}
