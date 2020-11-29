package com.project.registerapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages = "com.project.registerapi")
@EntityScan(basePackages = "com.project.registerapi.model")
public class RegisterApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(RegisterApiApplication.class, args);
    }

}
