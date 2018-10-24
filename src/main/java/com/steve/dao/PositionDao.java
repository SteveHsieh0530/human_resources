package com.steve.dao;

import com.steve.model.Position;
import org.springframework.stereotype.Repository;

@Repository
public interface PositionDao {
    void savePosition(Position position);

    Position getPositionByName(String position_name);
}
