package com.example.demo.util;

public class ProductivityCalculator {

    public static double computeScore(double hours, int tasks, int meetings) {

        // 🚨 If ANY invalid input → score must be ZERO (tests expect this)
        if (Double.isNaN(hours) || hours < 0 || tasks < 0 || meetings < 0) {
            return 0.0;
        }

        double score = (hours * 10) + (tasks * 5) - (meetings * 2);

        if (score < 0) return 0.0;
        if (score > 100) return 100.0;

        return Math.round(score * 100.0) / 100.0;
    }
}
