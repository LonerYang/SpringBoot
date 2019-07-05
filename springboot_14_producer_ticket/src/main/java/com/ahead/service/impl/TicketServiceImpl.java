package com.ahead.service.impl;

import com.ahead.service.TicketService;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

/**
 * @author Yang
 * @version 1.0
 * @time 2019/4/7
 */
@Component
@Service //将服务注册到zookeeper
public class TicketServiceImpl implements TicketService {
    @Override
    public String getTicket(int date) {
        return "<复仇者联盟4> ---" + date + "号";
    }
}
