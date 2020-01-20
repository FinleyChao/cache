package com.foolish.springcache.controller;
import	java.nio.file.Path;


import com.foolish.springcache.entity.Employee;
import com.foolish.springcache.service.IDepartmentService;
import com.foolish.springcache.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author cxf
 * @since 2020-01-11
 */
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private IEmployeeService employeeService;


    @GetMapping("/{id}")
    public Object getById(@PathVariable Long id){
        return employeeService.findById(id);
    }

    @GetMapping("/all" )
    public Object getAll(){
        return employeeService.findAll();
    }

    @PostMapping("/save")
    public Object save(@RequestBody Employee employee){
        employeeService.save(employee);
        return employee;
    }

    @PutMapping("/update")
    public Object update(@RequestBody Employee employee){
        return employeeService.updateEmp(employee);
    }

    @DeleteMapping("/{id}")
    public Object delete(@PathVariable Long id) {
        return employeeService.deleteById(id);
    }

    @GetMapping("/get")
    public Object getName(@RequestParam String name){
        return employeeService.getByName(name);
    }

}
