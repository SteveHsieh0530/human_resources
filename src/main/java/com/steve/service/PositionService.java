package com.steve.service;

import com.steve.model.Position;


public interface PositionService {
    boolean savePosition(Position position);

    Position getPositionByName(String position_name);
}
