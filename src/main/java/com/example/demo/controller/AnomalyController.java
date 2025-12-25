package com.example.demo.controller;

import com.example.demo.model.AnomalyFlagRecord;
import com.example.demo.service.AnomalyFlagService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/anomalies")
public class AnomalyController {

    private final AnomalyFlagService service;

    public AnomalyController(AnomalyFlagService service) {
        this.service = service;
    }

    @PostMapping
    public AnomalyFlagRecord flag(@RequestBody AnomalyFlagRecord r) {
        return service.flagAnomaly(r);
    }

    @PutMapping("/{id}/resolve")
    public AnomalyFlagRecord resolve(@PathVariable Long id) {
        return service.resolveAnomaly(id);
    }

    @GetMapping
    public List<AnomalyFlagRecord> all() {
        return service.getAllFlags();
    }
}
