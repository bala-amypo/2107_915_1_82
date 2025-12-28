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

        // 🔴 RESET BOTH FIELDS (VERY IMPORTANT)
        metric.setScore(0.0);
        metric.setProductivityScore(0.0);

        // Null safety
        if (metric.getHoursLogged() == null
                || metric.getTasksCompleted() == null
                || metric.getMeetingsAttended() == null) {
            return metric;
        }

        // Negative values → keep score = 0.0
        if (metric.getHoursLogged() < 0
                || metric.getTasksCompleted() < 0
                || metric.getMeetingsAttended() < 0) {
            return metric;
        }

        // Compute
        double score = ProductivityCalculator.computeScore(
                metric.getHoursLogged(),
                metric.getTasksCompleted(),
                metric.getMeetingsAttended()
        );

        // Clamp
        if (score < 0) score = 0.0;
        if (score > 100) score = 100.0;

        // 🔴 SET BOTH FIELDS
        metric.setScore(score);
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
