package com.example.demo.service;

import com.example.demo.model.ProductivityMetricRecord;
import java.util.List;

public interface ProductivityMetricService {
    ProductivityMetricRecord recordMetric(ProductivityMetricRecord r);
    ProductivityMetricRecord updateMetric(Long id, ProductivityMetricRecord r);
    List<ProductivityMetricRecord> getAllMetrics();
}
