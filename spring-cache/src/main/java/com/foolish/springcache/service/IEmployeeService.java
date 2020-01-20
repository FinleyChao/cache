package com.foolish.springcache.service;

import com.foolish.springcache.entity.Employee;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author cxf
 * @since 2020-01-11
 */
public interface IEmployeeService extends IService<Employee> {

    Object findById(Long id);

    Object findAll();

    Employee updateEmp(Employee employee);

    Boolean deleteById(Long id);

    Employee getByName(String name);
}
