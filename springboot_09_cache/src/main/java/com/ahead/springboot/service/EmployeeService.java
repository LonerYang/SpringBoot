package com.ahead.springboot.service;

import com.ahead.springboot.beans.Employee;
import com.ahead.springboot.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

/**
 * @author Yang
 * @version 1.0
 * @time 2019/4/1
 */

/**
 * @CacheConfig：抽取每个方法中相同的属性，这里只要定义一次就ok
 */
@CacheConfig(cacheNames = "emp")
@Service
public class EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;

    /**
     *
     * CacheManager管理多个Cache组件的，对缓存的真正CRUD操作在Cache组件中，每一个缓存组件有自己唯一一个名字；
     *
     * @Cacheable几个属性：
     *      cacheNames/value: 指定缓存组件的名字（缓存到哪个缓存组件中）
     *      key：缓存数据使用的key；可以用它来指定。默认是使用方法参数的值， 1-方法的返回值
     *              编写SpEl；#id;参数id的值  #a0  #p0     #root.args[0]
     *      keyGenerator：key的生成器；可以自己指定key的生成器的组件id(可以自定义一个KeyGenerator，然后注册到容器中)
     *              key/keyGenerator：二选一使用
     *      cacheManager：指定缓存管理器；或者cacheResolver指定获取解析器
     *      condition：指定符合条件的情况下才缓存
     *           condition = "#id > 1" ：id大于1才进行缓存
     *
     *      unless：否定缓存/排除条件；当unless指定的条件为true，方法的返回值就不会被缓存；可以获取到结果并进行判断
     *              unless = "#result == null"
     *              unless = "#id == 2" : id等于2就不缓存（如果满足condition也满足unless，以unless的为准）
     *      sync：是否同步；在多线程环境下，某些操作可能使用相同参数同步调用。
     *              默认情况下（默认不同步，也就是异步），缓存不锁定任何资源，可能导致多次计算，而违反了缓存的目的。
     *              对于这些特定的情况，属性 sync 可以指示底层将缓存锁住，使只有一个线程可以进入计算，而其他线程堵塞，
     *              直到返回结果更新到缓存中。
     *
     * 1、自动配置类；CacheAutoConfiguration
     * 2、缓存的配置类
     * "org.springframework.boot.autoconfigure.cache.GenericCacheConfiguration"
     * "org.springframework.boot.autoconfigure.cache.JCacheCacheConfiguration"
     * "org.springframework.boot.autoconfigure.cache.EhCacheCacheConfiguration"
     * "org.springframework.boot.autoconfigure.cache.HazelcastCacheConfiguration"
     * "org.springframework.boot.autoconfigure.cache.InfinispanCacheConfiguration"
     * "org.springframework.boot.autoconfigure.cache.CouchbaseCacheConfiguration"
     * "org.springframework.boot.autoconfigure.cache.RedisCacheConfiguration"
     * "org.springframework.boot.autoconfigure.cache.CaffeineCacheConfiguration"
     * "org.springframework.boot.autoconfigure.cache.SimpleCacheConfiguration"
     * "org.springframework.boot.autoconfigure.cache.NoOpCacheConfiguration"
     *
     * 3、哪个缓存配置类默认生效：SimpleCacheConfiguration
     * 4、给容器中注册了一个CacheManager：ConcurrentMapCacheManager
     * 5、可以获取和创建ConcurrentMapCache类型的缓存组件；它的作用是将数据保存在ConcurrentMap中
     *
     *   运行流程：以@Cacheable为例
     *   1、方法运行之前先去查询Cache，以cacheNames指定的名字获取
     *      （CacheManager先获取相应的缓存），第一次获取缓存如果没有Cache组件会自动创建
     *   2、去Cache中查找缓存的内容，使用一个key，默认就是方法的参数
     *      key是按照某种策略生成的，默认使用SimpleKeyGenerator生成key
     *          SimpleKeyGenerator生成key的默认策略：
     *              如果没有参数：key = new SimpleKey(new Object[0]));
     *              如果有一个参数： key = 参数的值
     *              如果有多个参数：key = new SimpleKey(params)
     *   3、在缓存中没有查到数据就调用目标方法
     *   4、将目标方法返回的结果，放进缓存中
     *
     * @Cacheable标注的方法执行之前先来检查缓存中有没有这个数据，默认按照参数的值作为key去查询缓存
     * 如果没有就运行方法并将结果放入缓存；以后再来调用就可以直接使用缓存中的数据
     *
     * @param id
     * @return
     */
    @Cacheable(cacheNames = {"emp"} /* condition = "#id > 1", unless = "#id == 2"*/)
    public Employee getEmployeeById(Integer id) {
        System.out.println(id + "号员工被查询");
        Employee employee = employeeMapper.selectEmployeeById(id);
        return employee;
    }

    /**
     * 运行流程：
     *      1、先调用目标方法（目标方法一定会被执行）
     *      2、将方法的返回值存到缓存中
     *
     * 测试步骤：
     *      1、查询1号员工，查到的结果会放在缓存中
     *      2、以后查询还是之前的结果
     *      3、更新1号员工【lastName:YRJ; gender:0】
     *              将方法的返回值也放进缓存了；
     *              key：默认是参数
     *      4、查询1号员工
     *          应该是更新后的员工；
     *          为什么是没更新的？
     *              因为所用的key不一致，导致缓存中有两份数据
     *          防止上述问题发生：
     *              指定一致的key
     * @Cacheable不能使用#result，因为它是先根据key查询缓存再执行目标方法，目标方法都没执行就要使用key，没有#result
     * @param employee
     * @return
     */
    @CachePut(/*cacheNames = {"emp"}, */key = "#result.id")
    public Employee modifyEmployeeById(Employee employee) {
        System.out.println(employee.getId() + "号员工被修改!");
        employeeMapper.updateEmployeeById(employee);
        return employee;
    }

    /**
     * @CacheEvict删除缓存中的数据
     *      key：指定要删除的key
     *
     *  allEntries：是否删除该缓存组件中的所有缓存（默认false）
     *  beforeInvocation：是否在目标方法执行之前清除缓存
     *      默认false：在目标方法执行之后清除缓存；如果目标方法执行时出错了就不会清楚缓存了
     *      beforeInvocation = true：在目标方法执行之前清除缓存；不管目标方法出错与否都会清除缓存
     * @param id
     */
    @CacheEvict(/*cacheNames = {"emp"},*/ /*key = "#id"*/ allEntries = true, beforeInvocation = true)
    public void removeEmployeeById(Integer id) {
        int i = 1 / 0;
        System.out.println(id + "号员工在缓存中被删除！");
        employeeMapper.deleteEmployeeById(id);
        //测试数据，所以这里不用删除数据库中的数据
    }

    /**
     * @Caching：配置复杂的缓存配置
     *
     * @param lastName
     * @return
     */
    @Caching(
         cacheable = {
                 @Cacheable(/*cacheNames = "emp",*/ key = "#lastName")
         },
         put = {
                 @CachePut(/*cacheNames = "emp",*/ key = "#result.id")
         }
    )
    public Employee getEmployeeByLastName(String lastName) {
        Employee employee = employeeMapper.selectEmployeeByLastName(lastName);
        return employee;
    }
}
