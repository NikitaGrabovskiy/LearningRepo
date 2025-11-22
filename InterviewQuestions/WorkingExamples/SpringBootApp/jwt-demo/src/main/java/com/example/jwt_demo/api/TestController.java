package com.example.jwt_demo.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.security.core.Authentication;
@RestController
@RequestMapping("/api")
public class TestController {

    @GetMapping("/hello")
    public String hello(Authentication auth) {
        return "Hello, %s!".formatted(auth.getName());
    }
}
