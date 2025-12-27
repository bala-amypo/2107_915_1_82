package com.example.demo.util;

import com.example.demo.model.Metric;

public class ProductivityCalculator {

    private ProductivityCalculator() {
        // utility class
    }

    public static double calculateScore(Metric metric) {

        if (metric == null) {
            return 0.0;
        }

        double hoursWorked = safe(metric.getHoursWorked());
        double meetings = safe(metric.getMeetings());
        double breaks = safe(metric.getBreaks());

        // If no work done, score must be zero
        if (hoursWorked <= 0) {
            return 0.0;
        }

        double score = (hoursWorked * 10)
                - (meetings * 2)
                - (breaks * 1.5);

        // Clamp negative values
        if (score < 0) {
            score = 0;
        }

        // Cap max score
        if (score > 100) {
            score = 100;
        }

        // Always return numeric rounded value
        return Math.round(score * 100.0) / 100.0;
    }

    private static double safe(Double value) {
        if (value == null || value.isNaN() || value.isInfinite()) {
            return 0.0;
        }
        return Math.max(0, value);
    }
}
