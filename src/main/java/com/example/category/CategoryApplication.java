package com.example.category;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class CategoryApplication {

    public static void main(String[] args) {
        // This boots up the ApplicationContext, starts Tomcat, and keeps the app running
        SpringApplication.run(CategoryApplication.class, args);
    }
}
