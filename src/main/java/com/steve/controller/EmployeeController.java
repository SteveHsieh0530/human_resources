package com.steve.controller;


import com.steve.dao.DepartmentDao;
import com.steve.model.Department;
import com.steve.model.Employee;
import com.steve.service.DepartmentService;
import com.steve.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Controller
public class EmployeeController {

    @Resource
    private EmployeeService employeeService;
    @Resource
    private DepartmentService departmentService;

    /*
        ajax 回应查询职位下的员工
     */
    @RequestMapping("/diff_pos")
    public @ResponseBody
    List<Employee> diff_pos (Integer selected){
        return employeeService.getEmployeeByPos(selected);
    }


    /*
        员工数量一定是挺多的，分页之后不可忘，现在先完成其他功能为优先
     */
    @RequestMapping("/goCheckAllEmployee")
    public String goCheckAllEmployee (Model model){
        List<Employee> employees = employeeService.getAllEmployee();
        model.addAttribute("employees", employees);
        return "/admin/showEmployees";
    }

    @RequestMapping("/updateEmployeeAdmin")
    public String updateEmployeeAdmin(Model model, Employee employee, Integer emp_pos_id){

        // 如果转正要先确定员工到目前时间是否有30天
        if(employee.getEmp_status() == 1){
            Date today = new Date();
            long todayLong = today.getTime();
            long empLong = employee.getEmp_create_time().getTime();
            Long timeDifference = (todayLong- empLong) / 1000/60/60/24;
            if(timeDifference <= 30){
                return showEmpDetail(employee.getEmp_id(), model);
            }
        }
        boolean check = employeeService.updateEmpByAdmin(employee.getEmp_id(),employee.getEmp_status(),emp_pos_id);
        return showEmpDetail(employee.getEmp_id(), model);
    }

    /*
        获得员工详情，且可以换员工岗位 需要有全部部门 然后用2级联动选择
     */
    @RequestMapping("/showEmpDetail")
    public String showEmpDetail(Integer emp_id, Model model){
        Employee employee = employeeService.getEmployeeByEmpId(emp_id);
        List<Department> departments = departmentService.getDepartmentsNotIncludeEmpId(emp_id);
        model.addAttribute("employee", employee);
        model.addAttribute("departments", departments);
        return "/admin/showEmpDetail";
    }
}
