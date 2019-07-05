package com.ahead.controller;

import com.ahead.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Yang
 * @version 1.0
 * @time 2019/4/7
 */
@RestController
public class AsyncController {

    @Autowired
    private AsyncService asyncService;

    @GetMapping("/hello")
    public String hello() {
        //调用异步方法
        asyncService.hello();
        //因为是异步的，所以这里会直接返回，上面由另外一个线程去执行
        return "success";
    }
}
