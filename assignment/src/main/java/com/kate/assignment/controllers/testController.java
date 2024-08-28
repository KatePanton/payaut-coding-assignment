package com.kate.assignment.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class testController {

    // https://spring.io/guides/gs/rest-service
    
    @GetMapping("/greeting")
    public String hello() {
        return "Hello java point";
    }
}