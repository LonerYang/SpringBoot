package com.ahead.springboot.service;

import com.ahead.springboot.beans.Department;
import com.ahead.springboot.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.support.SimpleValueWrapper;
import org.springframework.stereotype.Service;

/**
 * @author Yang
 * @version 1.0
 * @time 2019/4/3
 */
@Service
public class DepartmentService {


    @Autowired
    private CacheManager cacheManager;
    @Autowired
    private DepartmentMapper departmentMapper;

//    @Cacheable(cacheNames = "dept")
    public Department getDepartmentById(Integer id) {
        //业务中灵活的使用缓存；自动注入自定义好的deptCacheManager
        //获取名称为dept的缓存组件，没有默认会创建一个名称为dept的缓存组件
        Cache cache = cacheManager.getCache("dept");
        //先在缓存中查，没有查到再去数据库中查询然后再添加到缓存中去
        //在Redis中使用的key：cacheName::这里指定的key
        SimpleValueWrapper valueWrapper = (SimpleValueWrapper) cache.get(id);
        Department department = null;
        if (valueWrapper == null) {
            department = departmentMapper.selectDepartmentById(id);
            cache.put(id,department);
        } else {
            department = (Department)valueWrapper.get();
        }
        return department;
    }
}
