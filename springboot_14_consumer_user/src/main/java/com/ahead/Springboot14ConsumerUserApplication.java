package com.ahead;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 1、引入Dubbo和zookeeper的依赖
 * 2、使用@EnableDubbo开启注解
 * 3、配置应用的name、Dubbo的注册中心地址
 * 4、引用服务@Reference
 */
@EnableDubbo
@SpringBootApplication
public class Springboot14ConsumerUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot14ConsumerUserApplication.class, args);
    }

}
