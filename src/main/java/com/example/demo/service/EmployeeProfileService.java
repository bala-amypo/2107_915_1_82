package com.example.demo.service;

import com.example.demo.model.EmployeeProfile;

import java.util.List;
import java.util.Optional;

public interface EmployeeProfileService {

    EmployeeProfile createEmployee(EmployeeProfile employee);

    List<EmployeeProfile> getAllEmployees();

    Optional<EmployeeProfile> getEmployeeById(Long id);

    EmployeeProfile updateEmployee(EmployeeProfile employee);

    EmployeeProfile updateEmployeeStatus(Long id, boolean active);

    void deleteEmployee(Long id);

    // 🔴 Optional REQUIRED for isPresent() / isEmpty() tests
    Optional<EmployeeProfile> findByEmployeeId(String employeeId);
}
