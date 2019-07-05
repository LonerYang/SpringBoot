package com.ahead.service;

import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

/**
 * @author Yang
 * @version 1.0
 * @time 2019/4/7
 */
@Service
public class UserService {

    @Reference
    private TicketService ticketService;

    public String buyTicket(int date) {
        return ticketService.getTicket(date);
    }
}
