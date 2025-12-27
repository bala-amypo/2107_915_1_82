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

        Integer hours = metric.getHoursLogged();
        Integer tasks = metric.getTasksCompleted();
        Integer meetings = metric.getMeetingsAttended();

        double score = 0.0;

        // ✅ Null & negative safety (required by failing tests)
        if (hours != null && tasks != null && meetings != null &&
            hours >= 0 && tasks >= 0 && meetings >= 0) {

            score = ProductivityCalculator.computeScore(
                    hours.doubleValue(),
                    tasks.doubleValue(),
                    meetings.doubleValue()
            );

            if (Double.isNaN(score) || Double.isInfinite(score)) {
                score = 0.0;
            }
        }

        // ✅ Clamp (testScoreNeverExceeds100)
        if (score < 0) score = 0;
        if (score > 100) score = 100;

        // ✅ VERY IMPORTANT: convert to int (THIS FIXES YOUR ERROR)
        metric.setProductivityScore((int) Math.round(score));

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
