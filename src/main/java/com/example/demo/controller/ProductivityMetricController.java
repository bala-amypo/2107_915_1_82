package com.example.demo.controller;

import com.example.demo.model.ProductivityMetricRecord;
import com.example.demo.service.ProductivityMetricService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/metrics")
public class ProductivityMetricController {

    private final ProductivityMetricService service;

    public ProductivityMetricController(ProductivityMetricService service) {
        this.service = service;
    }

    @PostMapping
    public ProductivityMetricRecord record(@RequestBody ProductivityMetricRecord m) {
        return service.recordMetric(m);
    }

    @PutMapping("/{id}")
    public ProductivityMetricRecord update(@PathVariable Long id,
                                           @RequestBody ProductivityMetricRecord m) {
        return service.updateMetric(id, m);
    }

    @GetMapping
    public List<ProductivityMetricRecord> getAll() {
        return service.getAllMetrics();
    }
}
