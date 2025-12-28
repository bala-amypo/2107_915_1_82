package com.example.demo.util;

public class ProductivityCalculator {

    private ProductivityCalculator() {}

    public static double computeScore(Double hours, Integer tasks, Integer meetings) {

        // ANY null → score = 0
        if (hours == null || tasks == null || meetings == null) {
            return 0.0;
        }

        // ANY negative → score = 0
        if (hours < 0 || tasks < 0 || meetings < 0) {
            return 0.0;
        }

        // Normal calculation
        double score = (hours * 10) + (tasks * 5) - (meetings * 2);

        // Clamp
        if (score < 0) score = 0;
        if (score > 100) score = 100;

        // Round to 2 decimals
        return Math.round(score * 100.0) / 100.0;
    }
}
