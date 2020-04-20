package com.carrot.testspring.controller;

import com.carrot.testspring.bean.Department;
import com.carrot.testspring.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
/**
 * @author carrot
 */
@Controller
public class DeptController {

    @Autowired
    DepartmentMapper departmentMapper;

    @ResponseBody
    @GetMapping("/dept/{id}")
    public Department getDept(@PathVariable("id") Integer id){
        return departmentMapper.getDeptById(id);
    }

    @GetMapping("/dept")
    public Department insertDept(Department department){
          departmentMapper.insertDepd(department);
          return department;
    }

}
