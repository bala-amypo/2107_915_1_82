package com.example.demo.service.impl;

import com.example.demo.model.ProductivityMetricRecord;
import com.example.demo.repository.ProductivityMetricRecordRepository;
import com.example.demo.service.ProductivityMetricService;
import com.example.demo.util.ProductivityCalculator;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductivityMetricServiceImpl implements ProductivityMetricService {

    private final ProductivityMetricRecordRepository repo;

    public ProductivityMetricServiceImpl(ProductivityMetricRecordRepository repo) {
        this.repo = repo;
    }

    @Override
    public ProductivityMetricRecord save(ProductivityMetricRecord record) {
        double score = ProductivityCalculator.computeScore(
                record.getHoursWorked(),
                record.getTasksCompleted(),
                record.getMeetings()
        );
        record.setScore(score);
        return repo.save(record);
    }

    @Override
    public List<ProductivityMetricRecord> getAll() {
        return repo.findAll();
    }
}
