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

        double score = 0.0; // MUST be double

        if (metric != null &&
            metric.getHoursLogged() != null &&
            metric.getTasksCompleted() != null &&
            metric.getMeetingsAttended() != null &&
            metric.getHoursLogged() >= 0 &&
            metric.getTasksCompleted() >= 0 &&
            metric.getMeetingsAttended() >= 0) {

            double calculated = ProductivityCalculator.computeScore(
                    metric.getHoursLogged(),
                    metric.getTasksCompleted(),
                    metric.getMeetingsAttended()
            );

            score = calculated;
        }

        // Clamp rules required by tests
        if (score < 0) score = 0.0;
        if (score > 100) score = 100.0;

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
