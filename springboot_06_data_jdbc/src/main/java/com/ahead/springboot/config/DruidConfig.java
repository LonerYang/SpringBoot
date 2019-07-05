package com.ahead.springboot.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Yang
 * @version 1.0
 * @time 2019/2/15
 */
@Configuration
public class DruidConfig {

    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druidDataSource() {
        return new DruidDataSource();
    }

    //配置DruidDataSource的监控
    /**
     * 配置一个管理后台的Servlet
     * @return
     */
    @Bean
    public ServletRegistrationBean<StatViewServlet> statViewServlet() {
        ServletRegistrationBean<StatViewServlet> bean = new ServletRegistrationBean<>(new StatViewServlet());
        Map<String, String> initMap = new HashMap<>();
        //登陆的用户名 key在StatViewServlet的父类中能够找到
        initMap.put("loginUsername", "root");
        //登陆的密码
        initMap.put("loginPassword", "20180101");
        //允许哪个地址能访问  默认就是允许所有访问
        initMap.put("allow", "");
        //设置哪个不能访问
        initMap.put("deny", "192.168.0.125");
        //设置Servlet的初始化参数
        bean.setInitParameters(initMap);
        //设置访问路径
        bean.setUrlMappings(Arrays.asList("/druid/*"));
        return bean;
    }
    /**
     * 配置一个WEB监控的Filter
     * @return
     */
    @Bean
    public FilterRegistrationBean<WebStatFilter> webStatFilter() {
        FilterRegistrationBean<WebStatFilter> bean = new FilterRegistrationBean<>(new WebStatFilter());
        Map<String, String> initMap = new HashMap<>();
        //设置不拦截哪个请求
        initMap.put("exclusions", "*.js, *.css, /druid/**");
        //设置过滤器的初始化参数
        bean.setInitParameters(initMap);
        //设置什么都拦截，这样才能监控出数据
        bean.setUrlPatterns(Arrays.asList("/*"));
        return bean;
    }
}
