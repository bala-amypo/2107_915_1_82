package com.example.demo.service.impl;

import com.example.demo.model.ProductivityMetricRecord;
import com.example.demo.service.ProductivityMetricService;
import java.util.*;

public class ProductivityMetricServiceImpl implements ProductivityMetricService {

    public ProductivityMetricRecord recordMetric(ProductivityMetricRecord r) { return r; }
    public Optional<ProductivityMetricRecord> getMetricById(Long id) { return Optional.empty(); }
    public List<ProductivityMetricRecord> getAllMetrics() { return List.of(); }
}
