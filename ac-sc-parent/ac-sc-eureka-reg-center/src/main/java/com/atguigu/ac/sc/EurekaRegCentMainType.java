package com.atguigu.ac.sc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaRegCentMainType {

	public static void main(String[] args) {
		SpringApplication.run(EurekaRegCentMainType.class, args);
	}
}
