package com.ahead.springboot.controller;

import com.ahead.springboot.beans.Department;
import com.ahead.springboot.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Yang
 * @version 1.0
 * @time 2019/4/3
 */
@RestController
public class DepartmentController {


    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/dept/{id}")
    public Department getDepartmentById(@PathVariable Integer id) {

        Department department = departmentService.getDepartmentById(id);
        return department;
    }
}
