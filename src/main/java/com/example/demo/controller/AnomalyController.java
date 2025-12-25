package com.example.demo.controller;

import com.example.demo.model.AnomalyFlagRecord;
import com.example.demo.service.AnomalyFlagService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/anomalies")
public class AnomalyController {

    private final AnomalyFlagService service;

    public AnomalyController(AnomalyFlagService service) {
        this.service = service;
    }

    // GET – all anomaly flags
    @GetMapping
    public List<AnomalyFlagRecord> getAllFlags() {
        return service.getAllFlags();
    }

    // PUT – resolve anomaly
    @PutMapping("/{id}/resolve")
    public AnomalyFlagRecord resolveFlag(@PathVariable Long id) {
        return service.resolveFlag(id);
    }
}
