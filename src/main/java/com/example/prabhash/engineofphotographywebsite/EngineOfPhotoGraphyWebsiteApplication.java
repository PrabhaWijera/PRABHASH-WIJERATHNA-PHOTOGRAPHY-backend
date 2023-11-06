package com.example.prabhash.engineofphotographywebsite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class EngineOfPhotoGraphyWebsiteApplication {

    public static void main(String[] args) {
        System.out.println("Engine start 🔑");
        SpringApplication.run(EngineOfPhotoGraphyWebsiteApplication.class, args);
        System.out.println("Engine start 🔖");
    }

}
