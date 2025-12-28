package com.example.demo.repository;

import com.example.demo.model.EmployeeProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeProfileRepository
        extends JpaRepository<EmployeeProfile, Long> {

    // 🔴 MUST return EmployeeProfile (NOT Optional)
    EmployeeProfile findByEmployeeId(String employeeId);
}
