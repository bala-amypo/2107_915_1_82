package com.example.demo.util;

public class ProductivityCalculator {

    private ProductivityCalculator() {
        // utility class
    }

    public static double computeScore(double hours, int tasks, int meetings) {

        // Handle NaN or invalid values
        if (Double.isNaN(hours) || hours < 0 || tasks < 0 || meetings < 0) {
            return 0.0;
        }

        // Base score calculation
        double score = (hours * 5) + (tasks * 10);

        // Meeting penalty
        score -= meetings * 2;

        // Clamp between 0 and 100
        if (score < 0) {
            score = 0;
        } else if (score > 100) {
            score = 100;
        }

        // Round to 2 decimal places
        score = Math.round(score * 100.0) / 100.0;

        return score;
    }
}
