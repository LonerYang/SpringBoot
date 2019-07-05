package com.ahead.pojo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author Yang
 * @version 1.0
 * @time 2019/2/6
 * @ConfigurationProperties：告诉SpringBoot本类中的所有属性与配置文件中的属性进行绑定 使用该注解一定要使用@Component将该类放入容器中才能提供@ConfigurationProperties注解的功能
 * prefix = "person" 配置文件中将哪个下面的属性一一映射
 */

@ConfigurationProperties(prefix = "person")
@Component
//@PropertySource(value={"classpath:pojo.properties"})
public class Person {

//    @Value("${person.lastName}")
    private String lastName;

//    @Value("#{11*2}")
    private Integer age;

//    @Value("${person.maps}")
    private Map<String, Object> maps;
    private List<Object> lists;
    private Dog dog;

    @Override
    public String toString() {
        return "Person{" +
                "lastName='" + lastName + '\'' +
                ", age=" + age +
                ", maps=" + maps +
                ", lists=" + lists +
                ", dog=" + dog +
                '}';
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Map<String, Object> getMaps() {
        return maps;
    }

    public void setMaps(Map<String, Object> maps) {
        this.maps = maps;
    }

    public List<Object> getLists() {
        return lists;
    }

    public void setLists(List<Object> lists) {
        this.lists = lists;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }
}
