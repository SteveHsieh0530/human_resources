package com.steve.service.impl;

import com.steve.dao.DepartmentDao;
import com.steve.dao.PositionDao;
import com.steve.model.Department;
import com.steve.model.Position;
import com.steve.service.PositionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PositionServiceImpl implements PositionService {
    @Resource
    private PositionDao positionDao;
    @Resource
    private DepartmentDao departmentDao;


    @Override
    public boolean savePosition(Position position, String depart_name) {

        //判断重名
        List<Position> positions = positionDao.getAllPosition();
        for (Position p : positions) {
            if(position.getP_name().equals(p.getP_name())){
                return false;
            }
        }

        Department department = departmentDao.getDepartmentByName(depart_name); //　之后可看情况改成用ID查询
        position.setDepartment(department);
        positionDao.savePosition(position);
        return true;
    }

    @Override
    public Position getPositionByName(String position_name) {

        return positionDao.getPositionByName(position_name);
    }

    @Override
    public List<Position> getAllPositions() {

        return positionDao.getAllPosition();
    }

    @Override
    public boolean deletePosition(Integer selected) {
        positionDao.deletePosition(selected);
        return true;
    }

    @Override
    public boolean updatePosition(Position position) {
        positionDao.updatePosition(position);
        return false;
    }
}
