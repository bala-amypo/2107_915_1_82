package com.example.demo.service;

import com.example.demo.model.ProductivityMetricRecord;
import java.util.List;

public interface ProductivityMetricService {

    ProductivityMetricRecord recordMetric(ProductivityMetricRecord record);

    ProductivityMetricRecord updateMetric(Long id, ProductivityMetricRecord record);

    List<ProductivityMetricRecord> getAllMetrics();
}
