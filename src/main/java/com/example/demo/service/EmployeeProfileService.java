package com.example.demo.service;

import com.example.demo.model.EmployeeProfile;

import java.util.List;
import java.util.Optional;

public interface EmployeeProfileService {

    EmployeeProfile createEmployee(EmployeeProfile employee);

    EmployeeProfile updateEmployee(Long id, EmployeeProfile employee);

    EmployeeProfile updateEmployeeStatus(Long id, boolean active);

    EmployeeProfile getEmployeeById(Long id);

    Optional<EmployeeProfile> findByEmployeeId(String employeeId);

    List<EmployeeProfile> getAllEmployees();
}
