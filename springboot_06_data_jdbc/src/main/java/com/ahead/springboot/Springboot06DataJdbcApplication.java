package com.ahead.springboot;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

@SpringBootApplication
public class Springboot06DataJdbcApplication {

        public static void main(String[] args) {

        SpringApplication.run(Springboot06DataJdbcApplication.class, args);
    }


}

