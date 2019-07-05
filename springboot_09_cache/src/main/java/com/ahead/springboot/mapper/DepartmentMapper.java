package com.ahead.springboot.mapper;

import com.ahead.springboot.beans.Department;
import org.apache.ibatis.annotations.Select;

/**
 * @author Yang
 * @version 1.0
 * @time 2019/4/1
 */
public interface DepartmentMapper {

    /**
     * 根据id查询部门表
     * @param id
     * @return
     */
    @Select("SELECT * FROM department WHERE id = #{id}")
    Department selectDepartmentById(Integer id);

}
