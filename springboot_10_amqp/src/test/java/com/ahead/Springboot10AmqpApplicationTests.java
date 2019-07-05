package com.ahead;

import com.ahead.beans.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot10AmqpApplicationTests {
    /**
     * RabbitTemplate默认使用的是SimpleMessageConverter转换器（里面使用字节数组输出流通过UTF-8编码发送消息）
     * 可以自定义Json转换器
     */

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private AmqpAdmin amqpAdmin;

    @Test
    public void testSendMsg() {
        rabbitTemplate.convertAndSend("exchange.direct", "ahead.news",
                new Book("三国演义", "罗贯中"));
        rabbitTemplate.convertAndSend("exchange.direct", "ahead",
                new Book("三国演义", "罗贯中"));
    }


    @Test
    public void testAmqpAdmin1() {
        amqpAdmin.declareExchange(new DirectExchange("amqp.admin.exchange"));
    }
    @Test
    public void testAmqpAdmin2() {
        amqpAdmin.declareQueue(new Queue("amqp.admin.queue"));
    }
    @Test
    public void testAmqpAdmin3() {
        /**
         * param1：绑定目标的名称
         * param2：绑定目标的类型
         * param3：交换器名称
         * param4：绑定的路由键
         * param5：需要传的参数没有就传null
         */
        amqpAdmin.declareBinding(new Binding("amqp.admin.queue", Binding.DestinationType.QUEUE,
                "amqp.admin.exchange", "amqp.admin.key", null));
    }



    /**
     * 给direct类型的交换器发送消息（点对点）
     *
     */
    @Test
    public void contextLoads() {
        //可以通过配置文件自定义消息头和消息体
//        rabbitTemplate.send(exchange, routingKey, message);
        Map<String, Object> map = new HashMap<>();
        map.put("msg", "使用RabbitMQ发送的第一个消息");
        map.put("data", Arrays.asList("helloworld", true, 123));
        //常用的是下面这种方式，会自动转换消息头和消息体，只要传一个对象过去就行
        rabbitTemplate.convertAndSend("exchange.direct", "ahead.news", map);
    }

    /**
     * 接收消息
     */
    @Test
    public void receive() {
        //根据队列名称获取消息，但是需要自己手动转换
//        rabbitTemplate.receive(queueName);
        //常用的使用程序自动转换的方法
        Object message = rabbitTemplate.receiveAndConvert("ahead.news");
        System.out.println(message.getClass());
        System.out.println(message);
    }

    /**
     * 给fanout类型的交换器发送消息（一对多）
     */
    @Test
    public void sendFanout() {
        //fanout类型的交换器是接收一个消息会把接收的消息发送给所有与其绑定的所有队列
        rabbitTemplate.convertAndSend("exchange.fanout", "", new Book("红楼梦", "曹雪芹"));
    }


}
