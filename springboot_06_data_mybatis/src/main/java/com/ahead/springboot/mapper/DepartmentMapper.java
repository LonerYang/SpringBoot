package com.ahead.springboot.mapper;

import com.ahead.springboot.pojo.Department;
import org.apache.ibatis.annotations.*;

/**
 * @author Yang
 * @version 1.0
 * @time 2019/2/15
 */
//@Mapper
public interface DepartmentMapper {

    @Select("select * from department where id = #{id}")
    public Department selectDepartmentById(Integer id);

    @Delete("delete from department where id = #{id}")
    public int deleteDepartmentById(Integer id);

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into department(department_name) values(#{departmentName})")
    public int insertDepartment(Department department);

    @Update("update department set department_name = #{departmentName} where id = #{id}")
    public int updateDepartmentById(Department department);

}
