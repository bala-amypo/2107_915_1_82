package com.example.demo.service.impl;

import com.example.demo.model.ProductivityMetricRecord;
import com.example.demo.service.ProductivityMetricService;
import com.example.demo.util.ProductivityCalculator;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductivityMetricServiceImpl implements ProductivityMetricService {

    @Override
    public ProductivityMetricRecord recordMetric(ProductivityMetricRecord metric) {

        double hours = metric.getHoursLogged() == null ? 0.0 : metric.getHoursLogged();
        int tasks = metric.getTasksCompleted() == null ? 0 : metric.getTasksCompleted();
        int meetings = metric.getMeetingsAttended() == null ? 0 : metric.getMeetingsAttended();

        double score = ProductivityCalculator.computeScore(hours, tasks, meetings);
        metric.setProductivityScore(score);

        return metric;
    }

    @Override
    public Optional<ProductivityMetricRecord> getMetricById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<ProductivityMetricRecord> getAllMetrics() {
        return List.of();
    }
}
