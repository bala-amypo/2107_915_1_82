package com.example.demo.service.impl;

import com.example.demo.model.ProductivityMetricRecord;
import com.example.demo.repository.ProductivityMetricRepository;
import com.example.demo.service.ProductivityMetricService;
import com.example.demo.util.ProductivityCalculator;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductivityMetricServiceImpl implements ProductivityMetricService {

    private final ProductivityMetricRepository repository;

    public ProductivityMetricServiceImpl(ProductivityMetricRepository repository) {
        this.repository = repository;
    }

    @Override
    public ProductivityMetricRecord recordMetric(ProductivityMetricRecord metric) {

        // Defensive defaults
        if (metric.getHoursWorked() == null) metric.setHoursWorked(0.0);
        if (metric.getTasksCompleted() == null) metric.setTasksCompleted(0);
        if (metric.getMeetingsAttended() == null) metric.setMeetingsAttended(0);

        // Compute score STRICTLY
        double score = ProductivityCalculator.computeScore(
                metric.getHoursWorked(),
                metric.getTasksCompleted(),
                metric.getMeetingsAttended()
        );

        metric.setScore(score);

        return repository.save(metric);
    }

    @Override
    public Optional<ProductivityMetricRecord> getMetricById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<ProductivityMetricRecord> getAllMetrics() {
        return repository.findAll();
    }
}
