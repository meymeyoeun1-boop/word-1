package com.example.ecomerce.product.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Value("${app.welcome-message}")
    private String message;

    @GetMapping("/hello")
    public String sayHello() {
        return message; // Returns the text from the yml file!
    }
}
