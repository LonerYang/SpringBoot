package com.ahead.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot03LoggingApplicationTests {
    Logger logger = LoggerFactory.getLogger(Springboot03LoggingApplication.class);
    @Test
    public void contextLoads() {
        //logback日志级别：trace<debug<info<warn<error
        //Spring Boot默认日志级别就是info，因此会输出info以以上的日志信息
        logger.trace("trace级别的日志。。。");
        logger.debug("debug级别的日志。。。");
        logger.info("info级别的日志。。。");
        logger.warn("warn级别的日志。。。");
        logger.error("error级别的日志。。。");
    }

}

