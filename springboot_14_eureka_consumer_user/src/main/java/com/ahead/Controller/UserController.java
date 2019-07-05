package com.ahead.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author Yang
 * @version 1.0
 * @time 2019/4/8
 */
@RestController
public class UserController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/buy/{name}/{date}")
    public String buy(@PathVariable String name, @PathVariable int date) {
        String s = restTemplate.getForObject("http://PRODUCER-TICKET/ticket/"+date, String.class);
        return name + " buy " + s;
    }

}