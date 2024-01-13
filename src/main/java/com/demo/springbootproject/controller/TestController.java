package com.demo.springbootproject.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Value("${test.application.properties}")
    private String testMessage;

    @GetMapping("/test")
    public String hello() {
        return testMessage;
    }
}
