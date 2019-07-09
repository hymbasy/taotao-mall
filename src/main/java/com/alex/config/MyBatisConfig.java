package com.alex.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan({"com.alex.mapper","com.alex.dao"})
public class MyBatisConfig {
}
