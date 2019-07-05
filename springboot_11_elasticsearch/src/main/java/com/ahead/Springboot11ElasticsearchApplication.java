package com.ahead;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Boot默认支持两种技术来和ES交互
 *  1、Jest（默认不生效）
 *  需要导入Jest工具包（具体文档可去Github搜索）
 *  2、SpringData ElasticSearch（如果报超时错误就是ES版本不合适）
 *      版本适配说明：https://github.com/spring-projects/spring-data-elasticsearch
 *      如果版本不适配：
 *          1）、升级Springboot版本
 *          2）、安装对应版本ElasticSearch
 *       1）、Client节点信息clusterNodes；clusterName
 *       2）、ElasticsearchTempldate操作ES
 *       3）、编写一个ElasticsearchRepository的子接口来操作ES
 */
@SpringBootApplication
public class Springboot11ElasticsearchApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot11ElasticsearchApplication.class, args);
    }

}
