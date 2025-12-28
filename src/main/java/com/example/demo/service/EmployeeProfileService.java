package com.example.demo.service;

import com.example.demo.model.EmployeeProfile;
import java.util.List;
import java.util.Optional;

public interface EmployeeProfileService {

    EmployeeProfile createEmployee(EmployeeProfile employee);

    List<EmployeeProfile> getAllEmployees();

    Optional<EmployeeProfile> getEmployeeById(Long id);

    Optional<EmployeeProfile> findByEmployeeId(String employeeId);

    EmployeeProfile updateEmployee(EmployeeProfile employee);

    Optional<EmployeeProfile> updateEmployeeStatus(Long id, boolean active);

    void deleteEmployee(Long id);
}
