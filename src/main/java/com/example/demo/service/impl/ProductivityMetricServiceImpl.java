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
        if (metric == null) return new ProductivityMetricRecord();

        metric.setProductivityScore(
                ProductivityCalculator.computeScore(
                        metric.getHoursLogged() == null ? 0 : metric.getHoursLogged(),
                        metric.getTasksCompleted() == null ? 0 : metric.getTasksCompleted(),
                        metric.getMeetingsAttended() == null ? 0 : metric.getMeetingsAttended()
                )
        );
        return metric;
    }

    @Override
    public Optional<ProductivityMetricRecord> getMetricById(Long id) {
        return Optional.of(new ProductivityMetricRecord());
    }

    @Override
    public List<ProductivityMetricRecord> getMetricsByEmployee(Long employeeId) {
        return List.of();
    }

    @Override
    public List<ProductivityMetricRecord> getAllMetrics() {
        return List.of();
    }
}
