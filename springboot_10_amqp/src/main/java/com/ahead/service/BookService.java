package com.ahead.service;

import com.ahead.beans.Book;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * @author Yang
 * @version 1.0
 * @time 2019/4/5
 */
@Service
public class BookService {

    /**
     * 被@RabbitListener标注的方法用来监听指定的队列，只要队列中有消息进入就会以参数的形式接收到该消息
     * @param book
     */
    @RabbitListener(queues = "ahead.news")
    public void receive(Book book) {
        System.out.println(book);
    }

    @RabbitListener(queues = "ahead")
    public void receiveMessage(Message message) {
        System.out.println(message.getMessageProperties());
        System.out.println(message.getBody());
    }
}
