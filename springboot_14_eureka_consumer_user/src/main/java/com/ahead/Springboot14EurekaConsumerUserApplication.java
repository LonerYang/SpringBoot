package com.ahead;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * 开启发现服务功能
 */
@EnableDiscoveryClient
@SpringBootApplication
public class Springboot14EurekaConsumerUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot14EurekaConsumerUserApplication.class, args);
    }

    /**
     * @LoadBalanced开启负载均衡调用服务
     * @return
     */
    @LoadBalanced
    @Bean
    public RestTemplate restTemplate () {
        return new RestTemplate();
    }

}
