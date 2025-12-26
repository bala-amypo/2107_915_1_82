package com.example.demo.controller;

import com.example.demo.model.ProductivityMetricRecord;
import com.example.demo.service.ProductivityMetricService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/metrics")
public class ProductivityMetricController {

    @Autowired
    private ProductivityMetricService service;

    @PostMapping
    public ProductivityMetricRecord create(@RequestBody ProductivityMetricRecord m) {
        return service.recordMetric(m);
    }

    @GetMapping("/{id}")
    public Optional<ProductivityMetricRecord> getById(@PathVariable Long id) {
        return service.getMetricById(id);
    }

    @GetMapping
    public List<ProductivityMetricRecord> getAll() {
        return service.getAllMetrics();
    }
}
