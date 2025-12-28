package com.example.demo.repository;

import com.example.demo.model.ProductivityMetricRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductivityMetricRecordRepository
        extends JpaRepository<ProductivityMetricRecord, Long> {

    Optional<ProductivityMetricRecord> findByEmployeeId(Long employeeId);

    List<ProductivityMetricRecord> findAllByEmployeeId(Long employeeId);
}
