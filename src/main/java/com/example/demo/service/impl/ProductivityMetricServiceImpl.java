package com.example.demo.service.impl;

import com.example.demo.model.ProductivityMetricRecord;
import com.example.demo.repository.ProductivityMetricRepository;
import com.example.demo.service.ProductivityMetricService;
import com.example.demo.util.ProductivityCalculator;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductivityMetricServiceImpl
        implements ProductivityMetricService {

    private final ProductivityMetricRepository repository;

    public ProductivityMetricServiceImpl(ProductivityMetricRepository repository) {
        this.repository = repository;
    }

    @Override
    public ProductivityMetricRecord recordMetric(ProductivityMetricRecord metric) {

        /* ===============================
           🔐 FULL SANITIZATION (MANDATORY)
           =============================== */

        double hours = metric.getHoursWorked() == null || metric.getHoursWorked() < 0
                ? 0.0
                : metric.getHoursWorked();

        int tasks = metric.getTasksCompleted() == null || metric.getTasksCompleted() < 0
                ? 0
                : metric.getTasksCompleted();

        int meetings = metric.getMeetingsAttended() == null || metric.getMeetingsAttended() < 0
                ? 0
                : metric.getMeetingsAttended();

        /* ===============================
           📊 SCORE CALCULATION
           =============================== */

        double score = ProductivityCalculator.computeScore(
                hours, tasks, meetings
        );

        /* ===============================
           ✅ APPLY RESULTS BACK
           =============================== */

        metric.setHoursWorked(hours);
        metric.setTasksCompleted(tasks);
        metric.setMeetingsAttended(meetings);
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
