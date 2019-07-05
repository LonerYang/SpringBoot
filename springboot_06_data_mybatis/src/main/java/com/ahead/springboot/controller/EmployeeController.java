package com.ahead.springboot.controller;

import com.ahead.springboot.mapper.EmployeeMapper;
import com.ahead.springboot.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Yang
 * @version 1.0
 * @time 2019/2/15
 */
@RestController
public class EmployeeController {

    @Autowired
    private EmployeeMapper employeeMapper;

    @GetMapping("/emp/{id}")
    public Employee getEmployeeById(@PathVariable Integer id) {
        return employeeMapper.selectEmployeeById(id);
    }

    @GetMapping("/emp")
    public Employee saveEmployee(Employee employee) {
        employeeMapper.insertEmployee(employee);
        return employee;
    }
}
