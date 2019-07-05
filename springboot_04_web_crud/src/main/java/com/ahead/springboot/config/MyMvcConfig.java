package com.ahead.springboot.config;

import com.ahead.springboot.component.MyLocalResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Yang
 * @version 1.0
 * @time 2019/2/11
 */
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //设置视图映射，路径为/ahead将会映射到success的逻辑视图名上(由thymeleaf视图解析器解析)
        registry.addViewController("/ahead").setViewName("success");
    }


    @Bean
    public LocaleResolver localeResolver() {
        return new MyLocalResolver();
    }

    @Bean
    public WebMvcConfigurer webMvcConfigurer() {
        WebMvcConfigurer configurer = new WebMvcConfigurer() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("login");
                registry.addViewController(("/login")).setViewName("login");
                registry.addViewController("/index").setViewName("dashboard");
            }

            @Override
            public void addInterceptors(InterceptorRegistry registry) {
//                registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
//                        //设置不拦截登陆页面请求和处理登陆请求,不拦截webjars静态资源
//                        .excludePathPatterns("/login", "/", "/user/login", "/webjars/**");
            }
        };
        return configurer;
    }

}
