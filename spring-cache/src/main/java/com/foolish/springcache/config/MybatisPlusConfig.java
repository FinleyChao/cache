package com.foolish.springcache.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author chaoxianfei
 * @date 2020/01/11
 * @describe
 **/
//Spring boot方式
@EnableTransactionManagement
@Configuration
@MapperScan("com.foolish.springcache.mapper")
public class MybatisPlusConfig {

}
