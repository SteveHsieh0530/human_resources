package com.steve.controller;

import com.steve.dao.PositionDao;
import com.steve.model.Department;
import com.steve.model.Position;
import com.steve.service.PositionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class PositionController {
    @Resource
    private PositionService positionService;

    /*
       之后都该考虑将查看与创造 合成一个网页
    */
    @RequestMapping("/goCreatePosition")
    public String goCreatePosition(Model model){
        List<Position> positions = positionService.getAllPositions();
        model.addAttribute("positions", positions);
        return "/admin/createPosition";
    }

    /*
        之后应当改成选择职位部门时应该用下拉框选择
     */
    @RequestMapping("createPosition")
    public String createPosition(Position position, String depart_name){
        boolean check = positionService.savePosition(position, depart_name); //之后要考虑重名等问题
        return "/admin/adminMainPage";
    }

    @RequestMapping("/deletePosition")
    public String deletePosition (Integer selected, Model model){
        boolean check = positionService.deletePosition(selected);
        return goCreatePosition(model);
    }

    @RequestMapping("/updatePosition")
    public String updatePosition(Position position, Model model){
        boolean check = positionService.updatePosition(position);
        return goCreatePosition(model);
    }


}
