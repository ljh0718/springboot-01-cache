package com.atguigu.cache.mapper;


import com.atguigu.cache.bean.Department;
import org.apache.ibatis.annotations.Select;

/**
 * @author Mr.Z
 * @create 2019/8/6 10:18
 */
public interface DepartmentMapper {

    @Select("select * from department where id=#{id}")
    public Department getDeptById(Integer id);

}
