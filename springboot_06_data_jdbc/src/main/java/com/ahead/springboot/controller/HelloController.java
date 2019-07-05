package com.ahead.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @author Yang
 * @version 1.0
 * @time 2019/2/15
 */
@Controller
public class HelloController {

   @Autowired
   private JdbcTemplate jdbcTemplate;

   @RequestMapping("/query")
   @ResponseBody
   public Map<String, Object> query() {
      List<Map<String, Object>> mapList = jdbcTemplate.queryForList("select * from department");
      return mapList.get(0);
   }

}
