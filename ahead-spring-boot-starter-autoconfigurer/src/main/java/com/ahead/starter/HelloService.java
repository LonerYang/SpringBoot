package com.ahead.starter;

/**
 * @author Yang
 * @version 1.0
 * @time 2019/2/16
 */
public class HelloService {
    private HelloProperties helloProperties;

    public String sayHello() {
        return this.helloProperties.getName() + "  say:Hello,AHEAD!";
    }

    public HelloProperties getHelloProperties() {
        return helloProperties;
    }

    public void setHelloProperties(HelloProperties helloProperties) {
        this.helloProperties = helloProperties;
    }
}

