package com.ahead.springboot.controller;

import com.ahead.starter.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Yang
 * @version 1.0
 * @time 2019/2/16
 */
@RestController
public class HelloController {

    @Autowired
    private HelloService helloService;

    @GetMapping("/hello")
    public String sayHello() {
        return helloService.sayHello();
    }
}
