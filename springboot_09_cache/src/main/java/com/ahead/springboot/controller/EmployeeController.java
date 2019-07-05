package com.ahead.springboot.controller;

import com.ahead.springboot.beans.Employee;
import com.ahead.springboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Yang
 * @version 1.0
 * @time 2019/4/1
 */
@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/emp/{id}")
    public Employee getEmployeeById(@PathVariable Integer id) {
        Employee employee = employeeService.getEmployeeById(id);
        return employee;
    }

    @GetMapping("/emp")
    public Employee modifyEmployeeById(Employee employee) {
        Employee emp = employeeService.modifyEmployeeById(employee);
        return emp;
    }

    @GetMapping("/delemp/{id}")
    public String removeEmployeeById(@PathVariable Integer id) {
        employeeService.removeEmployeeById(id);
        return "success";
    }

    @GetMapping("/emp/lastname/{lastName}")
    public Employee getEmployeeByLastName(@PathVariable String lastName) {
        return employeeService.getEmployeeByLastName(lastName);
    }
}
