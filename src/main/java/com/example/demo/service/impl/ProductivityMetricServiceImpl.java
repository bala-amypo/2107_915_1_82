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

    @Override
    public ProductivityMetricRecord save(ProductivityMetricRecord m) {
        double score = ProductivityCalculator.computeScore(
                m.getHoursLogged(),
                m.getTasksCompleted(),
                m.getMeetingsAttended()
        );
        m.setProductivityScore(score);
        return repo.save(m);
    }

    @Override
    public List<ProductivityMetricRecord> findAll() {
        return repo.findAll();
    }
}
