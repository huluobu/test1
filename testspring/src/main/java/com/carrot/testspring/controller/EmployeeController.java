package com.carrot.testspring.controller;


import com.carrot.testspring.dao.DepartmentDao;
import com.carrot.testspring.dao.EmployeeDao;
import com.carrot.testspring.entities.Department;
import com.carrot.testspring.entities.Employee;
import com.carrot.testspring.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

/**
 * @author carrot
 */
@Controller
public class EmployeeController {

    @Autowired
    private EmployeeMapper employeeMapper;


    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private DepartmentDao departmentDao;
    //    查询员工页面
    @GetMapping("/emps")
    public String list(Model model){
        Collection<Employee> employees=employeeDao.getAll();
        model.addAttribute("emps",employees);
        return "emps/list";
    }

    @GetMapping("/emp")
    public String toAddPage(Model model){
        Collection<Department> departments=departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        return "emps/add";

    }

    @PostMapping("/emp")
    public String addemployee(Employee employee){
        employeeDao.save(employee);
        System.out.println("employee is:"+employee);

        return "redirect:/emps";
    }

    @GetMapping("/emp/{id}")
    public String modefiyemployee(@PathVariable Integer id,Model model){
        Employee employee=employeeDao.get(id);
        model.addAttribute("emp",employee);
        Collection<Department> departments=departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        return "emps/edit";
    }
    @PutMapping ("/emp")
    public String updateEmployee(Employee employee){
        System.out.println("修改的员工数据"+employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }


    @ResponseBody
    @GetMapping("/empt")
    public List<com.carrot.testspring.bean.Employee> getall(){
        return  employeeMapper.selectAll();
    }
}

