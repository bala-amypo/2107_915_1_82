package com.example.demo.service.impl;

import com.example.demo.model.ProductivityMetricRecord;
import com.example.demo.service.ProductivityMetricService;
import com.example.demo.util.ProductivityCalculator;

import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class ProductivityMetricServiceImpl implements ProductivityMetricService {

    private final Map<Long, ProductivityMetricRecord> store = new HashMap<>();

    @Override
    public ProductivityMetricRecord recordMetric(ProductivityMetricRecord record) {
        double score = ProductivityCalculator.computeScore(
                record.getHoursLogged(),
                record.getTasksCompleted(),
                record.getMeetingsAttended()
        );
        record.setProductivityScore(score);
        store.put(record.getEmployeeId(), record);
        return record;
    }

    @Override
    public Optional<ProductivityMetricRecord> getMetricById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public List<ProductivityMetricRecord> getAllMetrics() {
        return new ArrayList<>(store.values());
    }
}
