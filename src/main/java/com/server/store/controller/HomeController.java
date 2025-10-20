package com.server.store.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
@RestController
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public Map<String, Object> getHomeMessage() {
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Welcome to the Spring Boot Server Store...");
        response.put("status", "success");
        response.put("timestamp", System.currentTimeMillis());
        return response;
    }
}
