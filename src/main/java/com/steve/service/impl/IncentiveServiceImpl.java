package com.steve.service.impl;

import com.steve.dao.IncentiveDao;
import com.steve.service.IncentiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IncentiveServiceImpl implements IncentiveService {
    @Autowired
    private IncentiveDao incentiveDao;


}
