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

    // POST – record metric
    @PostMapping
    public ProductivityMetricRecord recordMetric(
            @RequestBody ProductivityMetricRecord metric) {
        return service.recordMetric(metric);
    }

    // PUT – update metric
    @PutMapping("/{id}")
    public ProductivityMetricRecord updateMetric(
            @PathVariable Long id,
            @RequestBody ProductivityMetricRecord metric) {
        return service.updateMetric(id, metric);
    }

    // GET – all metrics
    @GetMapping
    public List<ProductivityMetricRecord> getAllMetrics() {
        return service.getAllMetrics();
    }
}
