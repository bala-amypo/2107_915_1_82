package com.example.demo.service.impl;

import com.example.demo.model.ProductivityMetricRecord;
import com.example.demo.repository.ProductivityMetricRecordRepository;
import com.example.demo.service.ProductivityMetricService;
import com.example.demo.util.ProductivityCalculator;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductivityMetricServiceImpl implements ProductivityMetricService {

    private final ProductivityMetricRecordRepository repo;

    public ProductivityMetricServiceImpl(ProductivityMetricRecordRepository repo) {
        this.repo = repo;
    }

    public ProductivityMetricRecord recordMetric(ProductivityMetricRecord m) {
        double score = ProductivityCalculator.computeScore(
                m.getHoursWorked(),
                m.getTasksCompleted(),
                m.getMeetingsAttended()
        );
        m.setProductivityScore(score);
        return repo.save(m);
    }

    public ProductivityMetricRecord updateMetric(Long id, ProductivityMetricRecord m) {
        ProductivityMetricRecord old = repo.findById(id).orElseThrow();
        old.setHoursWorked(m.getHoursWorked());
        old.setTasksCompleted(m.getTasksCompleted());
        old.setMeetingsAttended(m.getMeetingsAttended());
        old.setProductivityScore(
                ProductivityCalculator.computeScore(
                        m.getHoursWorked(),
                        m.getTasksCompleted(),
                        m.getMeetingsAttended()
                )
        );
        return repo.save(old);
    }

    public List<ProductivityMetricRecord> getAllMetrics() {
        return repo.findAll();
    }
}
