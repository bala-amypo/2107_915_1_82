package com.example.demo.service;

import com.example.demo.model.ProductivityMetricRecord;

import java.util.List;
import java.util.Optional;

public interface ProductivityMetricService {

    ProductivityMetricRecord save(ProductivityMetricRecord record);

    Optional<ProductivityMetricRecord> findById(Long id);

    List<ProductivityMetricRecord> findAll();
}
