package com.steve.controller;

import com.steve.model.Department;
import com.steve.model.Interview;
import com.steve.model.Position;
import com.steve.service.DepartmentService;
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
    @Resource
    private DepartmentService departmentService;

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
    @RequestMapping("/goCreateNewDepartment")
    public String goCreateNewDepartment(){
        return "/admin/createNewDepartment";
    }

    /*
        以后修改要注意重名问题
     */
    @RequestMapping("/createNewDepartment")
    public String createNewDepartment(String department_name){
        boolean hello = departmentService.saveDepartment(department_name);  //因重名问题要判断是否ok


        return "/admin/adminMainPage";
    }
    /*
        之后都该考虑将查看与创造 合成一个网页
     */
    @RequestMapping("/goCreatePosition")
    public String goCreatePosition(){

        return "/admin/createPosition";
    }

    /*
        之后应当改成选择职位部门时应该用下拉框选择
     */
    @RequestMapping("createPosition")
    public String createPosition(Position position, String depart_name){
        Department department = departmentService.getDepartmentByName(depart_name); //　之后可看情况改成用ID查询
        position.setDepartment(department);


        return "";
    }

}
