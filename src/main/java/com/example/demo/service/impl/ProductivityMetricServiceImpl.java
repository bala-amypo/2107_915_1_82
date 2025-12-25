package com.example.demo.service.impl;

import com.example.demo.model.ProductivityMetricRecord;
import com.example.demo.repository.ProductivityMetricRecordRepository;
import com.example.demo.service.ProductivityMetricService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductivityMetricServiceImpl implements ProductivityMetricService {

    private final ProductivityMetricRecordRepository repo;

    public ProductivityMetricServiceImpl(ProductivityMetricRecordRepository repo) {
        this.repo = repo;
    }

    @Override
    public ProductivityMetricRecord recordMetric(ProductivityMetricRecord record) {
        return repo.save(record);
    }

    @Override
    public ProductivityMetricRecord updateMetric(Long id, ProductivityMetricRecord record) {
        ProductivityMetricRecord r = repo.findById(id).orElseThrow();
        r.setHoursWorked(record.getHoursWorked());
        r.setTasksCompleted(record.getTasksCompleted());
        r.setMeetings(record.getMeetings());
        return repo.save(r);
    }

    @Override
    public List<ProductivityMetricRecord> getAllMetrics() {
        return repo.findAll();
    }
}
package com.example.demo.service.impl;

import com.example.demo.model.ProductivityMetricRecord;
import com.example.demo.repository.ProductivityMetricRecordRepository;
import com.example.demo.service.ProductivityMetricService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductivityMetricServiceImpl implements ProductivityMetricService {

    private final ProductivityMetricRecordRepository repo;

    public ProductivityMetricServiceImpl(ProductivityMetricRecordRepository repo) {
        this.repo = repo;
    }

    @Override
    public ProductivityMetricRecord recordMetric(ProductivityMetricRecord record) {
        return repo.save(record);
    }

    @Override
    public ProductivityMetricRecord updateMetric(Long id, ProductivityMetricRecord record) {
        ProductivityMetricRecord r = repo.findById(id).orElseThrow();
        r.setHoursWorked(record.getHoursWorked());
        r.setTasksCompleted(record.getTasksCompleted());
        r.setMeetings(record.getMeetings());
        return repo.save(r);
    }

    @Override
    public List<ProductivityMetricRecord> getAllMetrics() {
        return repo.findAll();
    }
}
