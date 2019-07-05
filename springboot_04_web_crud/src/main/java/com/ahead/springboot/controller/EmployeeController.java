package com.ahead.springboot.controller;

import com.ahead.springboot.dao.DepartmentDao;
import com.ahead.springboot.dao.EmployeeDao;
import com.ahead.springboot.entities.Department;
import com.ahead.springboot.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * @author Yang
 * @version 1.0
 * @time 2019/2/12
 */
@Controller
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private DepartmentDao departmentDao;

    @GetMapping("/emps")
    public String listEmp(Model model) {
        Collection<Employee> empList = employeeDao.getAll();
        model.addAttribute("empList", empList);
        return "/emp/list";
    }

    @GetMapping("/emp")
    public String empAddPage(Model model) {
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departmentList", departments);
        return "/emp/add";
    }

    @PostMapping("/emp")
    public String saveEmp(Employee employee) {

        employeeDao.save(employee);
        //添加成功后重定向到查询页面
        return "redirect:/emps";
    }

    @GetMapping("/emp/{id}")
    public String echoEmp(@PathVariable Integer id, Model model) {
        Employee employee = employeeDao.get(id);
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departmentList", departments);
        model.addAttribute("emp", employee);
        return "/emp/add";
    }

    @PutMapping("/emp")
    public String updateEmp(Employee employee) {
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @DeleteMapping("/emp/{id}")
    public String deleteEmp(@PathVariable Integer id) {
        employeeDao.delete(id);
        return "redirect:/emps";
    }
}
