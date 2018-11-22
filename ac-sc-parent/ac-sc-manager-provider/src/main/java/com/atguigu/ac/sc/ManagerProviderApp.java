package com.atguigu.ac.sc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@MapperScan("com.atguigu.ac.sc.mapper")
public class ManagerProviderApp {

	public static void main(String[] args) {
		SpringApplication.run(ManagerProviderApp.class, args);
	}
}
