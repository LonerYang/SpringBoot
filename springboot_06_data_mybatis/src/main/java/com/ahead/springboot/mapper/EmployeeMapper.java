package com.ahead.springboot.mapper;

import com.ahead.springboot.pojo.Employee;

/**
 * @author Yang
 * @version 1.0
 * @time 2019/2/15
 */
//使用@Mapper注解或者在配置类上加@MapperScan扫描包的类名的方式加入容器
public interface EmployeeMapper {

    public Employee selectEmployeeById(Integer id);

    public int insertEmployee(Employee employee);
}
