package com.example.demo.service;

import com.example.demo.model.ProductivityMetricRecord;
import java.util.List;

public interface ProductivityMetricService {
    ProductivityMetricRecord save(ProductivityMetricRecord record);
    List<ProductivityMetricRecord> getAll();
}
