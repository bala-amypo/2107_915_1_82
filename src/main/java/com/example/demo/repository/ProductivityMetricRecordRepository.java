package com.example.demo.repository;

import com.example.demo.model.ProductivityMetricRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductivityMetricRecordRepository
        extends JpaRepository<ProductivityMetricRecord, Long> {

    ProductivityMetricRecord findByEmployeeId(Long employeeId);

    List<ProductivityMetricRecord> findAllByEmployeeId(Long employeeId);
}
