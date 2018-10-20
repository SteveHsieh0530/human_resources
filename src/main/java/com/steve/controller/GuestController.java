package com.steve.controller;


import com.steve.model.Guest;
import com.steve.model.Recruitment;
import com.steve.model.Resume;
import com.steve.service.GuestService;
import com.steve.service.RecruitmentService;
import com.steve.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class GuestController {

    @Resource
    private GuestService guestService;
    @Resource
    private ResumeService resumeService;
    @Autowired
    private RecruitmentService recruitmentService;

    @RequestMapping("/goRegister")
    public String goRegister(){
        return "/user/register";
    }
    @RequestMapping("/register")
    public String register (String acc, String pass){
        System.out.println(acc);
        System.out.println(pass);
        guestService.register(acc, pass);
        return goLogin();
    }

    @RequestMapping("/goLogin")
    public String goLogin(){
        System.out.println("pass go login");
        return "/user/login";
    }

    @RequestMapping("/login")
    public String login(String acc, String pass, HttpSession session){
        Guest guest = guestService.Login(acc, pass);
        session.setAttribute("guest", guest);
        return goGuestInfo(session);
    }

    @RequestMapping("/goGuestInfo")
    public String goGuestInfo(HttpSession session){
        return "/user/guestInfo";
    }

    @RequestMapping("/goWriteResume")
    public String goWriteResume(){
        return "/user/writeResume";
    }

    @RequestMapping("/saveResume")
    public String saveResume(Resume resume, HttpSession session) {
        Guest guest = (Guest) session.getAttribute("guest");
        resume.setG_id(guest.getG_id());

        resumeService.saveResume(resume);
        System.out.println(resume);

        System.out.println("已保存");
        return goGuestInfo(session);
    }

    @RequestMapping("/goGeneralMainPage")
    public String goGeneralMainPage(Model model){
        List<Recruitment> recruitments = recruitmentService.getAllRecruitments();
        model.addAttribute("recruitments", recruitments);

        return "generalMainPage";
    }

    @RequestMapping("/generateInterview")
    public String generateInterview(Model model){

        return goGeneralMainPage(model);
    }


}
