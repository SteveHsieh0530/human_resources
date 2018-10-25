package com.steve.controller;

import com.steve.model.Department;
import com.steve.service.DepartmentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.annotation.Resource;
import java.util.List;

@Controller
public class DepartmentController {
    @Resource
    private DepartmentService departmentService;

    @RequestMapping("/deleteDepartment")
    public String deleteDepartment(Integer dep_id, Model model){
        boolean check = departmentService.deleteDepartment(dep_id);
        return goCreateNewDepartment(model);
    }

    @RequestMapping("/updateDepartment")
    public String updateDepartment (Department department, Model model){

        boolean check = departmentService.updateDepartment(department);
        if(!check){
            model.addAttribute("fail_message", "已有相同名字的部门，请重新取名");
        }
        return goCreateNewDepartment(model);
    }

    @RequestMapping("/goCreateNewDepartment")
    public String goCreateNewDepartment(Model model){
        List<Department> department = departmentService.getAllDepartments();
        model.addAttribute("departments", department);

        return "/admin/createNewDepartment";
    }
    /*
        以后修改要注意重名问题
     */
    @RequestMapping("/createNewDepartment")
    public String createNewDepartment(String department_name, Model model){
        boolean check = departmentService.saveDepartment(department_name);  //因重名问题要判断是否ok
        if(!check){
            model.addAttribute("fail_message", "已有相同名字的部门，请重新取名");
        }
        return goCreateNewDepartment(model);
    }
    /*
        目前假想：先找出全部部门, 然后在页面选择部门的时候用ajax做2级联动显示职位以及员工信息
     */

    @RequestMapping("/checkDepartment")
    public String checkDepartment(){

        return "/admin/checkDepartment";
    }



}
