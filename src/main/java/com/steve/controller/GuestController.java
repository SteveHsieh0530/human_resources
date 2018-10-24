package com.steve.controller;


import com.steve.model.Guest;
import com.steve.model.Interview;
import com.steve.model.Recruitment;
import com.steve.model.Resume;
import com.steve.service.GuestService;
import com.steve.service.InterviewService;
import com.steve.service.RecruitmentService;
import com.steve.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
public class GuestController {

    @Resource
    private GuestService guestService;
    @Resource
    private ResumeService resumeService;
    @Autowired
    private RecruitmentService recruitmentService;
    @Autowired
    private InterviewService interviewService;


    @RequestMapping("/goRegister")
    public String goRegister(){
        return "/user/register";
    }
    @RequestMapping("/register")
    public String register (String acc, String pass){
        guestService.register(acc, pass);
        return goLogin();
    }

    @RequestMapping("/goLogin")
    public String goLogin(){
        return "/user/login";
    }

    @RequestMapping("/login")
    public String login(String acc, String pass, HttpSession session, Model model){
        //管理员这里的登录设计记得要改 目前只是方便测试
        if(acc.equals("admin") && pass.equals("admin")){
            return goAdminInfo();
        }else{
            Guest guest = guestService.Login(acc, pass);
            session.setAttribute("guest", guest);
            return goGuestInfo(session, model);
        }

    }
    @RequestMapping("/goAdminInfo")
    public String goAdminInfo(){
        return "/admin/adminMainPage";
    }


    @RequestMapping("/goGuestInfo")
    public String goGuestInfo(HttpSession session, Model model){
        Guest guest = (Guest) session.getAttribute("guest");
        List<Interview> interview = interviewService.getInterviewByGuestId(guest.getG_id());
        model.addAttribute("interviews", interview);
        return "/user/guestInfo";
    }

    @RequestMapping("/goWriteResume")
    public String goWriteResume(){
        return "/user/writeResume";
    }

    @RequestMapping("/saveResume")
    public String saveResume(Resume resume, HttpSession session, Model model) {
        Guest guest = (Guest) session.getAttribute("guest");
        resume.setGuest(guest);

        resumeService.saveResume(resume);
        System.out.println(resume);

        System.out.println("已保存");
        return goGuestInfo(session, model);
    }

    @RequestMapping("/goGeneralMainPage")
    public String goGeneralMainPage(Model model){
        List<Recruitment> recruitments = recruitmentService.getAllRecruitments();
        model.addAttribute("recruitments", recruitments);

        return "generalMainPage";
    }

    @RequestMapping("/generateInterview")
    public String generateInterview(Integer rec_id, HttpSession session, Model model){


        //生成新的面试邀请需要简历ID，用游客ID去查询
        Guest guest = (Guest) session.getAttribute("guest");
        Resume resume = resumeService.getResumeByGuestId(guest.getG_id());

        //需要招聘信息,管理员才清楚
        Recruitment recruitment = recruitmentService.getRecruitmentById(rec_id);

        Date date = new Date();
        Interview interview = new Interview();
        interview.setResume(resume);
        interview.setI_send_time(date);
        interview.setRecruitment(recruitment);

        interviewService.saveInterview(interview);

        return goGeneralMainPage(model);
    }

    @RequestMapping("/acceptInterview")
    public String acceptInterview (HttpSession session, Model model, Integer inter_id){
        Interview interview = interviewService.getInterviewById(inter_id);
        interview.setI_status(2); //status = 2 代表游客已接受面试邀请
        interviewService.updateInterview(interview);
        return goGuestInfo(session, model);
    }


    /*
        记住这个方法之后需要大改, 创建员工的时候应该要先去数据库确认已有的部门以及职位
        再到页面用下拉选单给管理员选择新创的员工所在的职位(2级联动?)
     */
    @RequestMapping("/goGenerateEmployee")
    public String goGenerateEmployee (Integer inter_id, Model model){
        Interview interview = interviewService.getInterviewById(inter_id);

        model.addAttribute("theResume", interview.getResume());
        return "/admin/showGenerateEmployee";
    }


}
