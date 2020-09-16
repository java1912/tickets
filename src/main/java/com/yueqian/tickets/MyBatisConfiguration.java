package com.yueqian.tickets;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.yueqian.tickets.mapper")
public class MyBatisConfiguration {

}
