package com.steve.service.impl;

import com.steve.dao.PositionDao;
import com.steve.model.Position;
import com.steve.service.PositionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PositionServiceImpl implements PositionService {
    @Resource
    private PositionDao positionDao;


    @Override
    public boolean savePosition(Position position) {
        positionDao.savePosition(position);
        return true;
    }

    @Override
    public Position getPositionByName(String position_name) {

        return positionDao.getPositionByName(position_name);
    }
}
