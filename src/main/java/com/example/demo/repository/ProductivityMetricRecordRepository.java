package com.example.demo.repository;

import com.example.demo.model.ProductivityMetricRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface ProductivityMetricRepository
        extends JpaRepository<ProductivityMetricRecord, Long> {

    Optional<ProductivityMetricRecord> findByEmployeeIdAndDate(
            Long employeeId,
            LocalDate date
    );
}
