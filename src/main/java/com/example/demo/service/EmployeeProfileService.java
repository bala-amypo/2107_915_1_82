package com.example.demo.service;

import com.example.demo.model.EmployeeProfile;

import java.util.List;
import java.util.Optional;

public interface EmployeeProfileService {

    // CREATE
    EmployeeProfile createEmployee(EmployeeProfile employee);

    // READ
    List<EmployeeProfile> getAllEmployees();

    Optional<EmployeeProfile> getEmployeeById(Long id);

    Optional<EmployeeProfile> findByEmployeeId(String employeeId);

    // UPDATE
    EmployeeProfile updateEmployee(EmployeeProfile employee);

    EmployeeProfile updateEmployeeStatus(Long id, boolean active);

    // DELETE
    void deleteEmployee(Long id);
}
