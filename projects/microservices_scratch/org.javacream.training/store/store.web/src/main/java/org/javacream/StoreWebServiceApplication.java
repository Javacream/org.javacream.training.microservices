package org.javacream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StoreWebServiceApplication {
    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(StoreWebServiceApplication.class);
        springApplication.setAdditionalProfiles("prod");
        springApplication.run(args);
    }

}
