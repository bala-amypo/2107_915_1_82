package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/anomaly-rules")
public class AnomalyRuleController {

    @PostMapping
    public String create() {
        return "rule-created";
    }

    @GetMapping
    public String list() {
        return "rules";
    }
}
