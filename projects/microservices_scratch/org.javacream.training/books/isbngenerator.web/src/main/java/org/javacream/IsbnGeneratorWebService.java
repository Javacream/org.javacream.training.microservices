package org.javacream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IsbnGeneratorWebService {
    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(IsbnGeneratorWebService.class);
        springApplication.setAdditionalProfiles("prod");
        springApplication.run(args);
    }
}
