package com.ahead;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource(value = {"classpath:service.xml"}) //导入Spring的配置文件使其生效
public class Springboot02ConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot02ConfigApplication.class, args);
    }

}