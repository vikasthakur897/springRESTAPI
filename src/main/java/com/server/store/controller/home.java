package com.server.store.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;


@AllArgsConstructor
@RestController
@RequestMapping("/")
public class home {

    @GetMapping()
    public String getMethodName() {
        return new String("Welcome to the Spring boot Server Store...");
    }
    
}
