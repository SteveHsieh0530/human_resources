package com.steve.service.impl;

import com.steve.dao.ResumeDao;
import com.steve.model.Resume;
import com.steve.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResumeServiceImpl implements ResumeService {

    @Autowired
    private ResumeDao resumeDao;

    @Override
    public boolean saveResume(Resume resume) {
        resumeDao.saveResume(resume);
        return true;
    }

    @Override
    public Resume getResumeByGuestId(Integer guest_id) {

        return resumeDao.getResumeByGuestId(guest_id);
    }
}
