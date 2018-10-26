package com.steve.dao;

import com.steve.model.Position;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PositionDao {
    void savePosition(Position position);

    Position getPositionByName(String position_name);

    List<Position> getAllPosition();

    void deletePosition(Integer selected);

    void updatePosition(Position position);

    List<Position> getPositionsByDepId(Integer selected);

    Position getPositionByPosId(Integer emp_pos_id);
}
