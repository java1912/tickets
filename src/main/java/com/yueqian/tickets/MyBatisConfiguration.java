package com.yueqian.tickets;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@MapperScan("com.yueqian.tickets.mapper")
public class MyBatisConfiguration {
	
	/**
	 * 加密
	 */
	@Bean
	public BCryptPasswordEncoder getBCryptPasswordEncoder() {
		BCryptPasswordEncoder e = new BCryptPasswordEncoder(12);
		return e;
	}

}
