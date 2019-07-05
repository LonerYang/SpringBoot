package com.ahead;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 1、将服务提供者注册到注册中心（zookeeper）
 *      1）、引入dubbo和zkClient的依赖
 *      2)、使用@EnableDubbo开启Dubbo
 *      3）、配置应用名称、注册中心地址、发布服务的端口号、采用dubbo协议
 *      4）、使用@Service（Dubbo的@Service）发布服务
 */
@EnableDubbo
@SpringBootApplication
public class Springboot14ProducerTicketApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot14ProducerTicketApplication.class, args);
    }

}
