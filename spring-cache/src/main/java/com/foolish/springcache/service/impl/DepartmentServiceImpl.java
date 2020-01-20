package com.foolish.springcache.service.impl;

import com.foolish.springcache.entity.Department;
import com.foolish.springcache.mapper.DepartmentMapper;
import com.foolish.springcache.service.IDepartmentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department> implements IDepartmentService {

}
