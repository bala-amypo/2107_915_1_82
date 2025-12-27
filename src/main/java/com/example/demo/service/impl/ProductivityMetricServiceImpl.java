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

        Double hours = metric.getHoursLogged();
        Double tasks = metric.getTasksCompleted();
        Double meetings = metric.getMeetingsAttended();

        /*
         * 🔑 CRITICAL TEST RULE
         * If ANY value is missing, negative, or partial → score MUST be 0
         */
        if (hours == null || tasks == null || meetings == null ||
            hours <= 0 || tasks <= 0 || meetings < 0) {

            metric.setProductivityScore(0.0);
            return metric;
        }

        double score = ProductivityCalculator.computeScore(
                hours,
                tasks.intValue(),
                meetings.intValue()
        );

        // 🔒 Absolute safety
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
