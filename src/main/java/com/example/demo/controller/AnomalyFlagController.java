package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/anomaly-flags")
public class AnomalyFlagController {


    @PostMapping
    public String flag() {
        return "flagged";
    }

    @PutMapping("/{id}/resolve")
    public String resolve(@PathVariable Long id) {
        return "resolved";
    }
}
