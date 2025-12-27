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

        // ✅ MODEL USES INTEGER — so respect it
        int hours = metric.getHoursLogged() != null ? metric.getHoursLogged() : 0;
        int tasks = metric.getTasksCompleted() != null ? metric.getTasksCompleted() : 0;
        int meetings = metric.getMeetingsAttended() != null ? metric.getMeetingsAttended() : 0;

        // ✅ Calculator returns double
        double score = ProductivityCalculator.computeScore(hours, tasks, meetings);

        // ✅ REQUIRED BY FAILING TESTS
        if (score < 0) {
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
