package com.example.demo.service.impl;

import com.example.demo.model.ProductivityMetricRecord;
import com.example.demo.repository.ProductivityMetricRecordRepository;
import com.example.demo.service.ProductivityMetricService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductivityMetricServiceImpl implements ProductivityMetricService {

    private final ProductivityMetricRecordRepository repo;

    public ProductivityMetricServiceImpl(ProductivityMetricRecordRepository repo) {
        this.repo = repo;
    }

    @Override
    public ProductivityMetricRecord recordMetric(ProductivityMetricRecord record) {
        return repo.save(record);
    }

    @Override
    public ProductivityMetricRecord updateMetric(Long id, ProductivityMetricRecord record) {
        record.setId(id);
        return repo.save(record);
    }

    @Override
    public Optional<ProductivityMetricRecord> getMetricById(Long id) {
        return repo.findById(id);
    }

    @Override
    public List<ProductivityMetricRecord> getAllMetrics() {
        return repo.findAll();
    }
}
