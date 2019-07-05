package com.ahead.springboot.controller;

import com.ahead.springboot.exception.UserNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Map;

/**
 * @author Yang
 * @version 1.0
 * @time 2019/2/8
 */
@Controller
public class HelloController {

    @RequestMapping("/hello")
    @ResponseBody
    public String hello(String user) {
        if(user.equals("aaa")) {
            throw new UserNotFoundException("用户不存在");
        }
        return "hello";
    }

    @RequestMapping("/success")
    public String success(Map<String, Object> map) {
        map.put("hello", "<h1>你好</h1>");
        map.put("users", Arrays.asList("张三", "李四", "王五"));
        return "success";
    }

}
