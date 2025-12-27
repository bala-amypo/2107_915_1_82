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

        Integer hoursInt = metric.getHoursLogged();
        Integer tasksInt = metric.getTasksCompleted();
        Integer meetingsInt = metric.getMeetingsAttended();

        double score = 0.0;

        // ✅ null & negative protection (required by tests)
        if (hoursInt != null && tasksInt != null && meetingsInt != null &&
            hoursInt >= 0 && tasksInt >= 0 && meetingsInt >= 0) {

            // ✅ EXPLICIT Integer → Double conversion (THIS FIXES YOUR ERROR)
            Double hours = hoursInt.doubleValue();
            Double tasks = tasksInt.doubleValue();
            Double meetings = meetingsInt.doubleValue();

            score = ProductivityCalculator.computeScore(
                    hours,
                    tasks,
                    meetings
            );

            // ✅ numeric safety
            if (Double.isNaN(score) || Double.isInfinite(score)) {
                score = 0.0;
            }
        }

        // ✅ clamp score (required by tests)
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
