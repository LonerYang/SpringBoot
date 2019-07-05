package com.ahead.config;

import com.ahead.service.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Yang
 * @version 1.0
 * @time 2019/2/6
 * @Configuration ：配置类 === 配置文件
 */
@Configuration
public class MyAppConfig {

    /**
     * @Bean 想当与Spring配置文件中的<bean></bean>
     * beanName 就是方法名
     * @return
     */
    @Bean
    public HelloService helloService2() {
        System.out.println("使用@Bean替代了配置文件");
        return new HelloService();
    }
}
