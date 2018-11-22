package com.atguigu.ac.sc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ActivitiProviderApp {

	public static void main(String[] args) {
		SpringApplication.run(ActivitiProviderApp.class, args);
	}
}
