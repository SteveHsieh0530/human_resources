package com.steve.controller;

import com.steve.model.*;
import com.steve.service.*;
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
    @Resource
    private PositionService positionService;
    @Resource
    private EmployeeService employeeService;
    @Resource
    private GuestService guestService;

    @RequestMapping("/checkInterview")
    public String checkInterview(Model model, Integer status){
        //List<Interview> interviews = interviewService.getAllInterviews();
        if(status == null){
            status = 3;     //测试用 默认值应当为0
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
        boolean check = positionService.savePosition(position); //之后要考虑重名等问题

        return "/admin/adminMainPage";
    }
    @RequestMapping("generateEmployee")
    public String generateEmployee(Employee employee, String position_name, Integer guest_id){
        //生成新账号需要除了从游客简历扒过来的信息外，还需要自动生成一个新账号(原本的游客账号+下划线+公司名malhaha, 密码不变)
        Position position = positionService.getPositionByName(position_name);
        employee.setPosition(position);
        employee.setEmp_salary(position.getP_salary()); //自动生成时薪水是职位的默认薪水

        //获得游客账号密码
        Guest guest = guestService.getGuestById(guest_id);
        String emp_acc = guest.getG_name() + "_malhaha";
        employee.setEmp_acc(emp_acc);   //账号为原本游客账号+下划线+公司名
        employee.setEmp_pass(guest.getG_pass()); //密码为游客原本密码


        boolean check = employeeService.saveEmployee(employee);

        return "/admin/adminMainPage";
    }

}
