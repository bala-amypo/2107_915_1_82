package com.example.demo.controller;

import com.example.demo.model.ProductivityMetricRecord;
import com.example.demo.service.ProductivityMetricService;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/metrics")
public class ProductivityMetricController {

    private final ProductivityMetricService service;

    public ProductivityMetricController(ProductivityMetricService service) {
        this.service = service;
    }

    @PostMapping
    public ProductivityMetricRecord create(@RequestBody ProductivityMetricRecord record) {
        return service.recordMetric(record);
    }

    @GetMapping
    public List<ProductivityMetricRecord> getAll() {
        return service.getAllMetrics();
    }
}
