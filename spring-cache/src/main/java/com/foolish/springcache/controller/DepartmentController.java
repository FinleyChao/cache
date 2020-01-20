package com.foolish.springcache.controller;


import com.foolish.springcache.entity.Employee;
import com.foolish.springcache.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author cxf
 * @since 2020-01-11
 */
@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private IDepartmentService departmentService;

    @GetMapping("/{id}")
    public Object getById(@PathVariable Long id){
        return departmentService.getById(id);
    }

    @GetMapping("/all" )
    public Object getAll(){
        return departmentService.list();
    }



}
