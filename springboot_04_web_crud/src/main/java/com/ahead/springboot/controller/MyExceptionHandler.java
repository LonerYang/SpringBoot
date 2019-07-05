package com.ahead.springboot.controller;

import com.ahead.springboot.exception.UserNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Yang
 * @version 1.0
 * @time 2019/2/13
 */
@ControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public String handleException(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        map.put("message", "user not found");
        request.setAttribute("ext", map);
        return "dispatcher:/error";
    }
}
