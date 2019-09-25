package com.example.service_discovery_client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableAutoConfiguration
public class ServiceDiscoveryClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceDiscoveryClientApplication.class, args);
	}

}
