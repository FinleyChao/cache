package com.foolish.springcache;

import com.foolish.springcache.entity.Department;
import com.foolish.springcache.entity.Employee;
import com.foolish.springcache.enums.GenderEnum;
import com.foolish.springcache.service.IDepartmentService;
import com.foolish.springcache.service.IEmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;

@SpringBootTest
class SpringCacheApplicationTests {

    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    private IDepartmentService departmentService;

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @Resource
    private RedisTemplate<String, Object> empRedisTemplate;


    @Test
    void contextLoads() {
        Employee employee = Employee.builder().name("李四").email("lisi@qq.com").gender(GenderEnum.WOMAN).departmentId(1L).build();
        boolean save = employeeService.save(employee);
        System.out.println("保存：" + save);
    }

    @Test
    public void test1(){
        Department department = Department.builder().departmentName("销售部").build();
        boolean save = departmentService.save(department);
        System.out.println("保存：" + save);
    }

    @Test
    public void test2(){
       /* Employee employee = employeeService.getById(1L);
        redisTemplate.opsForValue().set("emp1",employee);*/
        Object name = redisTemplate.opsForValue().get("emp::3");
        System.out.println(name);
    }

}
