package com.ahead.springboot.config;

import com.ahead.springboot.filter.MyFilter;
import com.ahead.springboot.listener.MyListener;
import com.ahead.springboot.servlet.MyServlet;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * @author Yang
 * @version 1.0
 * @time 2019/2/13
 */
@Configuration
public class MyServerConfig {

    /**
     * 嵌入式服务器配置
     * @return
     */
    @Bean
    public WebServerFactoryCustomizer<ConfigurableWebServerFactory> webServerFactoryCustomizer() {

        return new WebServerFactoryCustomizer<ConfigurableWebServerFactory>(){
            @Override
            public void customize(ConfigurableWebServerFactory factory) {
                factory.setPort(8081);
            }
        };
    }

    //下面是Servlet中的三大组件配置servlet,filter,listener

    /**
     * 注册Servlet
     * @return
     */
    @Bean
    public ServletRegistrationBean<MyServlet> servletRegistrationBean() {
        //Servlet的配置都可以在ServletRegistrationBean对象中配置
        ServletRegistrationBean<MyServlet> myServletServletRegistrationBean = new ServletRegistrationBean<>();
        myServletServletRegistrationBean.setServlet(new MyServlet());
        myServletServletRegistrationBean.setUrlMappings(Arrays.asList("/myServlet"));
        return myServletServletRegistrationBean;
    }

    /**
     * 配置Filter
     * @return
     */
    @Bean
    public FilterRegistrationBean<MyFilter> filterRegistrationBean() {
        FilterRegistrationBean<MyFilter> myFilterFilterRegistrationBean = new FilterRegistrationBean<>();
        myFilterFilterRegistrationBean.setFilter(new MyFilter());
        myFilterFilterRegistrationBean.setUrlPatterns(Arrays.asList("/hello", "/"));
        return myFilterFilterRegistrationBean;
    }

    @Bean
    public ServletListenerRegistrationBean<MyListener> servletListenerRegistrationBean() {
        return new ServletListenerRegistrationBean(new MyListener());
    }
}
