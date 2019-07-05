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

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() {
        return new DruidDataSource();
    }

    @Bean
    public ServletRegistrationBean<StatViewServlet> statViewServlet() {
        ServletRegistrationBean<StatViewServlet> bean = new ServletRegistrationBean<>(new StatViewServlet());
        Map<String, String> initMap = new HashMap<>();
        initMap.put("loginUsername", "root");
        initMap.put("loginPassword", "20180101");
        initMap.put("allow", "");
        initMap.put("deny", "192.168.0.125");
        bean.setUrlMappings(Arrays.asList("/druid/*"));
        bean.setInitParameters(initMap);
        return bean;
    }

    @Bean
    public FilterRegistrationBean<WebStatFilter> webStatFilter() {
        FilterRegistrationBean<WebStatFilter> bean = new FilterRegistrationBean<>(new WebStatFilter());
        Map<String, String> initMap = new HashMap<>();
        initMap.put("exclusions", "*.jsp, *.css, /druid/*");
        bean.setUrlPatterns(Arrays.asList("/*"));
        bean.setInitParameters(initMap);
        return bean;
    }
}
