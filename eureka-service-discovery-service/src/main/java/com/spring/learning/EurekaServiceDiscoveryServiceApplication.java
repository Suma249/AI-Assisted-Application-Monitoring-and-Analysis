package com.spring.learning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServiceDiscoveryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaServiceDiscoveryServiceApplication.class, args);
	}

}
