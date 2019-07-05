package com.ahead.springboot.controller;

import com.ahead.springboot.mapper.DepartmentMapper;
import com.ahead.springboot.pojo.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Yang
 * @version 1.0
 * @time 2019/2/15
 */

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentMapper departmentMapper;

    @GetMapping("/getDepartmentById")
    public Department getDepartmentById(Integer id) {
        return departmentMapper.selectDepartmentById(id);
    }

    @GetMapping("/saveDepartment")
    public Department saveDepartment(Department department) {
        departmentMapper.insertDepartment(department);
        return department;
    }
}
