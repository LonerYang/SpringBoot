package com.ahead.springboot.config;

import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author Yang
 * @version 1.0
 * @time 2019/4/2
 */
@Configuration
public class MyKeyGenerator {

    @Bean
    public KeyGenerator myGenerator() {
      return new KeyGenerator(){
            @Override
            public Object generate(Object target, Method method, Object... params) {
                return method.getName() + Arrays.asList(params).toString() + "yang";
            }
        };
    }
}
