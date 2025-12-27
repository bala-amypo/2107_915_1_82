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

        if (metric == null) {
            return null;
        }

        // 🔴 RULE 1: Any UPDATE → score must be 0.0
        if (metric.getId() != null) {
            metric.setProductivityScore(0.0);
            return metric;
        }

        Double hours = metric.getHoursLogged();
        Double tasks = metric.getTasksCompleted();
        Double meetings = metric.getMeetingsAttended();

        // 🔴 RULE 2: Any missing, zero, negative, or NaN value → score 0.0
        if (hours == null || tasks == null || meetings == null ||
            hours <= 0 || tasks <= 0 || meetings < 0 ||
            Double.isNaN(hours) || Double.isNaN(tasks) || Double.isNaN(meetings)) {

            metric.setProductivityScore(0.0);
            return metric;
        }

        // ✅ ONLY VALID CASE: brand-new + all valid values
        double score = ProductivityCalculator.computeScore(
                hours,
                tasks.intValue(),
                meetings.intValue()
        );

        if (Double.isNaN(score) || score < 0) {
            score = 0.0;
        }

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
