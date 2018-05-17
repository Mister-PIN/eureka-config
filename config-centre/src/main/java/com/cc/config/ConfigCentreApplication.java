package com.cc.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.bootstrap.encrypt.RsaProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
@EnableConfigServer
@EnableDiscoveryClient
public class ConfigCentreApplication {


	public static void main(String[] args) {
		SpringApplication.run(ConfigCentreApplication.class, args);
	}
}
