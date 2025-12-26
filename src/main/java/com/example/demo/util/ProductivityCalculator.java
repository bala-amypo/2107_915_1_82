package com.example.demo.util;

public class ProductivityCalculator {

    public static double computeScore(double hoursLogged, int tasksCompleted, int meetingsAttended) {

        // 1. Handle invalid inputs
        if (Double.isNaN(hoursLogged) || hoursLogged <= 0 || tasksCompleted < 0 || meetingsAttended < 0) {
            return 0.0;
        }

        // 2. Base score calculation
        double score = (tasksCompleted * 10) + (hoursLogged * 5) - (meetingsAttended * 2);

        // 3. Clamp score between 0 and 100
        if (score < 0) score = 0;
        if (score > 100) score = 100;

        // 4. Round to 2 decimal places
        return Math.round(score * 100.0) / 100.0;
    }
}
