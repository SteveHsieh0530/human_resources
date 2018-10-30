package com.steve.controller;

import com.steve.service.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TrainingController {
    @Autowired
    private TrainingService trainingService;

    @RequestMapping("/goShowTraining")
    public String goShowTraining(){
        return "/admin/goShowTraining";
    }

    
}
