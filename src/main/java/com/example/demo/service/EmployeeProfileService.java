package com.example.demo.service;

import com.example.demo.model.EmployeeProfile;

import java.util.List;

public interface EmployeeProfileService {

    EmployeeProfile createEmployee(EmployeeProfile employee);

    List<EmployeeProfile> getAllEmployees();

    EmployeeProfile getEmployeeById(Long id);

    EmployeeProfile findByEmployeeId(String employeeId);

    EmployeeProfile updateEmployee(EmployeeProfile employee);

    EmployeeProfile updateEmployeeStatus(Long id, boolean active);

    void deleteEmployee(Long id);
}
