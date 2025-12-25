package com.example.demo.service;

import com.example.demo.model.ProductivityMetricRecord;
import java.util.List;

public interface ProductivityMetricService {
    ProductivityMetricRecord recordMetric(ProductivityMetricRecord m);
    ProductivityMetricRecord updateMetric(Long id, ProductivityMetricRecord m);
    List<ProductivityMetricRecord> getAllMetrics();
}
