package com.steve.service;

import com.steve.model.Position;

import java.util.List;


public interface PositionService {
    boolean savePosition(Position position, String depart_name);
    Position getPositionByName(String position_name);

    List<Position> getAllPositions();

    boolean deletePosition(Integer selected);

    boolean updatePosition(Position position);

    List<Position> getPositionsByDepId(Integer selected);
}
