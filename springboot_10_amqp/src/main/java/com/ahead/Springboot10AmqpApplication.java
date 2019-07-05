package com.ahead;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 自动配置：
 * 1、RabbitAutoConfiguration
 * 2、自动配置了连接工厂RabbitConnectionFactory
 * 3、RabbitProperties封装了RabbitMQ的配置
 * 4、RedisTemplate：给RabbitMQ发送和接收消息
 * 5、AmqpAdmin：RabbitMQ系统管理组件
 *      可以用来创建Exchange、Queue和Binding
 */
@EnableRabbit
@SpringBootApplication
public class Springboot10AmqpApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot10AmqpApplication.class, args);
    }

}
