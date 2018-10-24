package com.steve.controller;

import com.steve.model.Interview;
import com.steve.service.InterviewService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class AdminController {

    @Resource
    private InterviewService interviewService;

    @RequestMapping("/checkInterview")
    public String checkInterview(Model model, Integer status){
        //List<Interview> interviews = interviewService.getAllInterviews();
        if(status == null){
            status = 0;
        }
        List<Interview> interviews = interviewService.getInterviewByStatus(status);

        model.addAttribute("interviews", interviews);
        return "/admin/showInterviews";
    }

    @RequestMapping("/inviteInterview")
    public String inviteInterview(Model model, Integer inter_id){
        Interview interview = interviewService.getInterviewById(inter_id);
        interview.setI_status(1);
        interviewService.updateInterview(interview);
        return checkInterview(model, 0);
    }


}
