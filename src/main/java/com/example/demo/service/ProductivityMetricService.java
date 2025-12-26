package com.example.demo.service;

import com.example.demo.model.ProductivityMetricRecord;
import java.util.*;

public interface ProductivityMetricService {

    ProductivityMetricRecord recordMetric(ProductivityMetricRecord record);
    Optional<ProductivityMetricRecord> getMetricById(Long id);
    List<ProductivityMetricRecord> getAllMetrics();
    ProductivityMetricRecord updateMetric(Long id, ProductivityMetricRecord record);
}
