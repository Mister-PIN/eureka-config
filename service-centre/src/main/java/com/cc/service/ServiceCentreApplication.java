package com.cc.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ServiceCentreApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceCentreApplication.class, args);
	}
}
