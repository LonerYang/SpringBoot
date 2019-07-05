package com.ahead.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Yang
 * @version 1.0
 * @time 2019/2/15
 */
@Controller
public class SuccessController {

    @GetMapping("/success")
    public String success(Model model) {
        model.addAttribute("msg", "成功");
        return "success";
    }
}
