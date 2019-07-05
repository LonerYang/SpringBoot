package com.ahead.controller;

import com.ahead.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Yang
 * @version 1.0
 * @time 2019/4/8
 */
@RestController
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @GetMapping("/ticket/{date}")
    public String ticket(@PathVariable int date) {
        System.out.println("8002");
        return ticketService.getTicket(date);
    }
}
