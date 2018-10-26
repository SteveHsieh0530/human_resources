package com.steve.controller;

import com.steve.model.Recruitment;
import com.steve.service.RecruitmentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class RecruController {
    @Resource
    private RecruitmentService recruitmentService;

    @RequestMapping("/goShowRecruitment")
    public String goShowRecruitment(Model model){
        List<Recruitment> recruitments = recruitmentService.getAllRecruitments();
        model.addAttribute("recruitments", recruitments);
        return "/admin/showRecruitment";
    }
    /*
        之后可能传参会改成传职位id 暂时先用职位名字
     */
    @RequestMapping("/createNewRecruitment")
    public String createNewRecruitment(Recruitment recruitment, String position_name, Model model){
        boolean hello = recruitmentService.createRecruitment(recruitment, position_name);


        return goShowRecruitment(model);
    }
    @RequestMapping("/updateRecruitment")
    public String updateRecruitment(Model model, Recruitment recruitment, String position_name ){
        boolean check = recruitmentService.updateRecruitment(recruitment, position_name);
        return goShowRecruitment(model);
    }

    @RequestMapping("/deleteRecruitment")
    public String deleteRecruitment(Model model, Integer recru_id){
        boolean check = recruitmentService.deleteRecruitment(recru_id);
        return goShowRecruitment(model);
    }


}
