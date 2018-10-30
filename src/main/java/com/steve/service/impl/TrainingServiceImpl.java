package com.steve.service.impl;

import com.steve.dao.TrainingDao;
import com.steve.service.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrainingServiceImpl implements TrainingService {
    @Autowired
    private TrainingDao trainingDao;


}
