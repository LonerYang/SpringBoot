package com.ahead.springboot.mapper;

import com.ahead.springboot.beans.Employee;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @author Yang
 * @version 1.0
 * @time 2019/4/1
 */
public interface EmployeeMapper {

    /**
     * 增加员工
     * @param employee
     */
    @Insert("INSERT INTO employee (lastName, email, gender, d_id) VALUES(#{lastName}, #{email}, #{gender}, #{dId})")
    void insertEmployee(Employee employee);

    /**
     * 根据id删除员工
     * @param id
     */
    @Delete("DELETE FROM employee WHERE id = #{id}")
    void deleteEmployeeById(Integer id);

    /**
     * 根据id修改员工
     * @param employee
     */
    @Update("UPDATE employee SET lastName = #{lastName}, email = #{email}, gender = #{gender}, d_id = #{dId} WHERE id = #{id}")
    void updateEmployeeById(Employee employee);

    /**
     * 根据id查询员工
     * @param id
     * @return
     */
    @Select("SELECT * FROM employee WHERE id = #{id}")
    Employee selectEmployeeById(Integer id);

    /**
     * 根据lastName查询员工
     * @param lastName
     */
    @Select("SELECT * FROM employee WHERE lastName = #{lastName}")
    Employee selectEmployeeByLastName(String lastName);
}
