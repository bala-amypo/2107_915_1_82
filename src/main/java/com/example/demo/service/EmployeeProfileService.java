package com.example.demo.service;

import com.example.demo.model.EmployeeProfile;

import java.util.List;
import java.util.Optional;

public interface EmployeeProfileService {

    EmployeeProfile createEmployee(EmployeeProfile e);

    EmployeeProfile getEmployeeById(Long id);

    List<EmployeeProfile> getAllEmployees();

    Optional<EmployeeProfile> findByEmployeeId(String employeeId);

    EmployeeProfile updateEmployee(EmployeeProfile e);

    EmployeeProfile updateEmployeeStatus(Long id, boolean active);

    void deleteEmployee(Long id);
}
