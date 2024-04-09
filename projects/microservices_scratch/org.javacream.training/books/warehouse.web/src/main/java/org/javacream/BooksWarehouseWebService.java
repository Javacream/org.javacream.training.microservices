package org.javacream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BooksWarehouseWebService {
    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(BooksWarehouseWebService.class);
        springApplication.setAdditionalProfiles("prod");
        springApplication.run(args);
    }
}
