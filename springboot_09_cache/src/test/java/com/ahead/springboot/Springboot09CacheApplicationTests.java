package com.ahead.springboot;

import com.ahead.springboot.beans.Employee;
import com.ahead.springboot.mapper.EmployeeMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot09CacheApplicationTests {

    @Autowired
    private EmployeeMapper employeeMapper;

    /**
     * k-v都是Object类型
     */
    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;


    /**
     * k-v都是String类型的
     */
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * Redis五大数据类型：String(字符串)、Hash(哈希表)、Set(集合)、List(链表)、Zset(有序集合)
     * opsForValue[String]
     * opsForHash[Hash]
     * opsForSet[Set]
     * opsForList[List]
     * opsForZset[Zset]
     */
    @Test
    public void test01() {
//        ValueOperations<String, String> string = stringRedisTemplate.opsForValue();
//        string.set("k1", "Hello");
//        String v1 = string.get("k1");
//        System.out.println(v1);
        ListOperations<String, String> list = stringRedisTemplate.opsForList();
        list.leftPush("mylist", "1");
//        String mylistVal = list.leftPop("mylist");
//        System.out.println(mylistVal);
    }

    @Test
    public void test02() {
        //源码可以找到默认使用JdkSerializationRedisSerializer，
        //可以自定义Serializer；eg：这里自定义一个Json序列化器
        ValueOperations<Object, Object> string = redisTemplate.opsForValue();
        Employee employee = employeeMapper.selectEmployeeById(1);
        string.set("emp01", employee);
    }

    @Test
    public void testInsertEmployee() {
        Employee employee = new Employee();
        employee.setLastName("Yang");
        employee.setEmail("yang@gmail.com");
        employee.setGender(1);
        employee.setDId(1);
        employeeMapper.insertEmployee(employee);
    }

}
