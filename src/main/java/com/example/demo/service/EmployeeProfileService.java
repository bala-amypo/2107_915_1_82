package com.example.demo.service;

import com.example.demo.model.EmployeeProfile;

import java.util.Optional;

public interface EmployeeProfileService {

    Optional<EmployeeProfile> findByEmployeeId(String employeeId);

    EmployeeProfile save(EmployeeProfile profile);

    void deleteEmployee(Long id);
}
