package com.yc.user;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;

@ServletComponentScan
@SpringBootApplication
@EnableRabbit
@EnableCaching
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class UserApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(UserApplication.class, args);
		
	}

}
