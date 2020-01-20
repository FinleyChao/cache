package com.foolish.springcache.service.impl;

import com.foolish.springcache.entity.Employee;
import com.foolish.springcache.mapper.EmployeeMapper;
import com.foolish.springcache.service.IEmployeeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author cxf
 * @since 2020-01-11
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements IEmployeeService {

    @Autowired
    private IEmployeeService employeeService;

    @Override
    @Cacheable(value = "emp", key = "#a0")
    public Object findById(Long id) {
        System.out.println("---findById---");
        return employeeService.getById(id);
    }

    @Override
    @Cacheable(value = "allEmp")
    public Object findAll() {
        System.out.println("---findAll--");
        return employeeService.list();
    }

    @Override
    @CachePut(value = "emp", key = "#result.id")
    public Employee updateEmp(Employee employee) {
        employeeService.updateById(employee);
        return employee;
    }

    @Override
    @CacheEvict(value = "emp", key = "#id")
    public Boolean deleteById(Long id) {
        System.out.println("删除员工信息：" + id);
        return true;
    }

    @Override
    @Caching(
            cacheable = {
                    @Cacheable(value = "emp", key = "#name")
            },
            put = {
                    @CachePut(value = "emp", key = "#result.id")
            }
    )
    public Employee getByName(String name) {
        Employee one = employeeService.lambdaQuery().eq(Employee::getName, name).one();
        return one;
    }
}
