package com.atguigu.cache.mapper;

import com.atguigu.cache.bean.Employee;
import org.apache.ibatis.annotations.*;

/**
 * @author Mr.Z
 * @create 2019/8/6 10:18
 */
@Mapper
public interface EmployeeMapper {

    @Select("select * from employee where id=#{id}")
    public Employee getEmpById(Integer id);

    @Update("update employee set lastName=#{lastName},email=#{email},gender=#{gender},d_id=#{dId} where id=#{id}")
    public void updateEmp(Employee employee);

    @Delete("delete from employee where id =#{id}")
    public void deleteById(Integer id);

    @Insert("insert into employee(lastName,email,gender,d_id) values(#{lastName},#{email},#{gender},#{dId})")
    public void insertEp(Employee employee);

    @Select("select * from employee where lastName = #{lastName}")
    public Employee getEmpByLastName(String lastName);
}
