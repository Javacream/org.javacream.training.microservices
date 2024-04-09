package org.javacream.training.spring.cloud.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigServerStarter {
	public static void main(String[] args) {
		SpringApplication.run(ConfigServerStarter.class, args);
	
	}
}
