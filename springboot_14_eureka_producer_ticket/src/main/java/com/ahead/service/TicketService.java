package com.ahead.service;

import org.springframework.stereotype.Service;

/**
 * @author Yang
 * @version 1.0
 * @time 2019/4/8
 */
@Service
public class TicketService {

    public String getTicket(int date) {
        return "<复仇者联盟4> ---" + date + "号";
    }
}
