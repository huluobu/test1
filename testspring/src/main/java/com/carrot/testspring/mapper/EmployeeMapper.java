package com.carrot.testspring.mapper;

import com.carrot.testspring.bean.Employee;

import java.util.List;

/**
 * @author carrot
 */
public interface EmployeeMapper {

    List<Employee> selectAll();

    int insertEmp(Employee employee);
}
