package com.ahead.starter;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Yang
 * @version 1.0
 * @time 2019/2/16
 */
@ConfigurationProperties(prefix = "ahead.hello")
public class HelloProperties {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
