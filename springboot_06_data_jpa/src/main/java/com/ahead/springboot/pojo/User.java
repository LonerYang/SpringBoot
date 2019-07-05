package com.ahead.springboot.pojo;

import lombok.Data;

import javax.persistence.*;

/**
 * @author Yang
 * @version 1.0
 * @time 2019/2/16
 */
@Entity //该pojo是与数据库表映射
@Table(name = "t_user") //指定数据库的表名 默认为类名小写
@Data
public class User {

    /**
     * 指定该属性是主键，并指定自增策略
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "last_name", length = 20)
    private String lastName;

    /**
     * 省略字段名默认就是属性名
     */
    @Column
    private String email;
}
