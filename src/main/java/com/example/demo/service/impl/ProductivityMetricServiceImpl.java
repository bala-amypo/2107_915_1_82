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

        int finalScore = 0;

        // ✅ null + negative protection (TEST REQUIRED)
        if (hours != null && tasks != null && meetings != null &&
            hours >= 0 && tasks >= 0 && meetings >= 0) {

            Double rawScore = ProductivityCalculator.computeScore(
                    hours,
                    tasks,
                    meetings
            );

            // Safety checks
            if (rawScore != null && !rawScore.isNaN() && !rawScore.isInfinite()) {

                // Clamp before converting
                if (rawScore < 0) rawScore = 0.0;
                if (rawScore > 100) rawScore = 100.0;

                finalScore = rawScore.intValue(); // ✅ REQUIRED
            }
        }

        // ✅ setter expects int
        metric.setProductivityScore(finalScore);

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
