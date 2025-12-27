package com.example.demo.util;

public class ProductivityCalculator {

    public static double computeScore(double hours, double tasks, double meetings) {

        // Normalize invalid values
        if (Double.isNaN(hours) || hours < 0) hours = 0;
        if (Double.isNaN(tasks) || tasks < 0) tasks = 0;
        if (Double.isNaN(meetings) || meetings < 0) meetings = 0;

        // Core formula
        double score = (hours * 10.0) + (tasks * 5.0) - (meetings * 2.0);

        // Clamp score (required by tests)
        if (score < 0) score = 0;
        if (score > 100) score = 100;

        // Round to 2 decimals
        return Math.round(score * 100.0) / 100.0;
    }
}
