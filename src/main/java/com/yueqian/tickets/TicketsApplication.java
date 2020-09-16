package com.yueqian.tickets;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.core.convert.converter.Converter;

import com.yueqian.tickets.util.DateUtil;

@SpringBootApplication
@Import({MyBatisConfiguration.class})
public class TicketsApplication {

	public static void main(String[] args) {
		SpringApplication.run(TicketsApplication.class, args);
	}

	@Bean
	public Converter<String, Date> getDateConverter(){
		return new Converter<String, Date>(){

			@Override
			public Date convert(String source) {
				return DateUtil.parseDate2YMD(source);
			}
			
		};
	}
}
