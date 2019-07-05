package com.ahead.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Yang
 * @version 1.0
 * @time 2019/2/6
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }
}
