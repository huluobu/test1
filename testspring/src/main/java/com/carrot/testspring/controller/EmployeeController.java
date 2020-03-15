package com.carrot.testspring.controller;


import com.carrot.testspring.dao.DepartmentDao;
import com.carrot.testspring.dao.EmployeeDao;
import com.carrot.testspring.entities.Department;
import com.carrot.testspring.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.sql.Connection;
import java.util.Collection;

/**
 * @author carrot
 */
@Controller
public class EmployeeController {
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
        System.out.println(employee);
        employeeDao.save(employee);
        return "redirect:/emps/list";
    }
}

