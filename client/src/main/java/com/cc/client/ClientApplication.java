package com.cc.client;

import com.netflix.appinfo.InstanceInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class ClientApplication {
	@Autowired
	private Registration registration;
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private DiscoveryClient discoveryClient;


	@RequestMapping("/client")
	public String index() {
		//获得Eureka instance的信息，传入Application NAME
		List<ServiceInstance> instances = discoveryClient.getInstances(registration.getServiceId());
		for (ServiceInstance instance : instances) {
			System.out.println(instance.getUri()+" : "+ registration.getServiceId());
		}
		System.out.println("path= " +instances.get(0).getUri().getHost());
		return instances.get(0).getUri().getHost();
	}

	public static void main(String[] args) {
		SpringApplication.run(ClientApplication.class, args);
	}
}
