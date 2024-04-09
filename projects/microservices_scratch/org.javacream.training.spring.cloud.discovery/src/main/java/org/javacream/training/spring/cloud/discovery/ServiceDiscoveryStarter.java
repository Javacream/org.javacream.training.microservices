package org.javacream.training.spring.cloud.discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ServiceDiscoveryStarter {
	public static void main(String[] args) {
		SpringApplication.run(ServiceDiscoveryStarter.class, args);
	
	}
}
