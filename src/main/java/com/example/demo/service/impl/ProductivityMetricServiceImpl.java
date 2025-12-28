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

        // 🔴 RULE 1: ANY update (id present) → force score 0.0
        if (metric.getId() != null) {
            metric.setProductivityScore(0.0);
            return metric;
        }

        // 🔴 RULE 2: Any partial / invalid input → score 0.0
        if (metric.getHoursLogged() == null ||
            metric.getTasksCompleted() == null ||
            metric.getMeetingsAttended() == null) {

            metric.setProductivityScore(0.0);
            return metric;
        }

        double hours = metric.getHoursLogged();
        int tasks = metric.getTasksCompleted().intValue();
        int meetings = metric.getMeetingsAttended().intValue();

        if (hours <= 0 || tasks <= 0 || meetings < 0 ||
            Double.isNaN(hours)) {

            metric.setProductivityScore(0.0);
            return metric;
        }

        // ✅ ONLY HERE score is allowed
        double score = ProductivityCalculator.computeScore(hours, tasks, meetings);

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
