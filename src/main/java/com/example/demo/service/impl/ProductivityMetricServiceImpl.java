package com.example.demo.service.impl;

import com.example.demo.model.ProductivityMetric;
import com.example.demo.service.ProductivityMetricService;
import org.springframework.stereotype.Service;

@Service
public class ProductivityMetricServiceImpl implements ProductivityMetricService {

    @Override
    public ProductivityMetric recordMetric(ProductivityMetric metric) {

        // 🔒 Null safety
        if (metric == null) {
            ProductivityMetric empty = new ProductivityMetric();
            empty.setScore(0.0);
            return empty;
        }

        Integer workHours = metric.getWorkHours();
        Integer meetings = metric.getMeetings();
        Integer breaks = metric.getBreaks();

        double score = calculateScore(workHours, meetings, breaks);
        metric.setScore(score);

        return metric;
    }

    @Override
    public ProductivityMetric updateMetric(ProductivityMetric metric) {

        // 🔒 Null safety
        if (metric == null) {
            ProductivityMetric empty = new ProductivityMetric();
            empty.setScore(0.0);
            return empty;
        }

        Integer workHours = metric.getWorkHours();
        Integer meetings = metric.getMeetings();
        Integer breaks = metric.getBreaks();

        double score = calculateScore(workHours, meetings, breaks);
        metric.setScore(score);

        return metric;
    }

    // =====================================================
    // ✅ CORE LOGIC — THIS FIXES BOTH FAILING TESTS
    // =====================================================
    private double calculateScore(
            Integer workHours,
            Integer meetings,
            Integer breaks
    ) {
        // 1️⃣ Null check → numeric safe
        if (workHours == null || meetings == null || breaks == null) {
            return 0.0;
        }

        // 2️⃣ Negative clamp → REQUIRED by test
        if (workHours < 0 || meetings < 0 || breaks < 0) {
            return 0.0;
        }

        double score = 0.0;

        // Base productivity
        score += workHours * 10.0;

        // Penalties
        score -= meetings * 5.0;
        score -= breaks * 2.0;

        // 3️⃣ Clamp score range
        if (score < 0) {
            score = 0.0;
        }
        if (score > 100) {
            score = 100.0;
        }

        // 4️⃣ Always numeric & rounded
        return Math.round(score * 10.0) / 10.0;
    }
}
