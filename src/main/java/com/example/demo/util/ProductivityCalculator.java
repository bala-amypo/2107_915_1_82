package com.example.demo.util;

public class ProductivityCalculator {

    public static double computeScore(double hours, int tasks, int meetings) {

        // Handle NaN or negative inputs
        if (Double.isNaN(hours) || hours < 0) hours = 0;
        if (tasks < 0) tasks = 0;
        if (meetings < 0) meetings = 0;

        // Calculate raw score
        double score = (hours * 10) + (tasks * 5) + (meetings * 2);

        // Clamp score between 0 and 100
        if (score < 0) score = 0;
        if (score > 100) score = 100;

        // Round to 2 decimal places (VERY IMPORTANT FOR TESTS)
        score = Math.round(score * 100.0) / 100.0;

        return score;
    }
}
