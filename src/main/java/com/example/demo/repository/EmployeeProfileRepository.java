package com.example.demo.repository;

import com.example.demo.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;

public interface EmployeeProfileRepository extends JpaRepository<EmployeeProfile, Long> {
    Optional<EmployeeProfile> findByEmployeeId(String employeeId);
}

public interface ProductivityMetricRecordRepository extends JpaRepository<ProductivityMetricRecord, Long> {
    List<ProductivityMetricRecord> findByEmployeeId(Long employeeId);
}

public interface AnomalyRuleRepository extends JpaRepository<AnomalyRule, Long> {
    List<AnomalyRule> findByActiveTrue();
}

public interface AnomalyFlagRecordRepository extends JpaRepository<AnomalyFlagRecord, Long> {
    List<AnomalyFlagRecord> findByMetricId(Long metricId);
}
