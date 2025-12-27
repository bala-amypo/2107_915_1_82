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

        Double score = 0.0;   // ✅ MUST be Double

        // ✅ Null + negative protection (required by tests)
        if (hours != null && tasks != null && meetings != null &&
            hours >= 0 && tasks >= 0 && meetings >= 0) {

            Double rawScore = ProductivityCalculator.computeScore(
                    hours,
                    tasks,
                    meetings
            );

            if (rawScore != null && !rawScore.isNaN() && !rawScore.isInfinite()) {

                // Clamp score
                if (rawScore < 0) rawScore = 0.0;
                if (rawScore > 100) rawScore = 100.0;

                score = rawScore;
            }
        }

        // ✅ Setter expects Double — NOT int
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
