package com.ahead.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Yang
 * @version 1.0
 * @time 2019/2/12
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @PostMapping("/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password, HttpServletRequest request) {
        //这里只校验密码
        if(!StringUtils.isEmpty(password) && "12345".equals(password)) {
            //密码是12345登陆成功，重定向到主页
            request.getSession().setAttribute("user", username);
            return "redirect:/index";
        } else {
            //否则密码错误，转发到登陆界面显示错误信息
            request.setAttribute("msg", "用户名密码错误");
            return "/login";
        }
    }
}
