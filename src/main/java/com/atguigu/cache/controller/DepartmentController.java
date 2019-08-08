package com.atguigu.cache.controller;

import com.atguigu.cache.bean.Department;
import com.atguigu.cache.bean.Employee;
import com.atguigu.cache.service.DepartmentService;
import com.atguigu.cache.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Mr.Z
 * @create 2019/8/6 10:37
 */
@RestController
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @GetMapping("/dept/{id}")
    public Department getEmp(@PathVariable("id") Integer id){
        Department dept = departmentService.getDeptById(id);
        return dept;
    }

}
