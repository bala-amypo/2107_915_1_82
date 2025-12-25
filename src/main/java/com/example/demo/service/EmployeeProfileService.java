package com.example.demo.service;

import com.example.demo.model.EmployeeProfile;
import java.util.List;

public interface EmployeeProfileService {
    EmployeeProfile createEmployee(EmployeeProfile e);
    EmployeeProfile updateEmployee(Long id, EmployeeProfile e);
    EmployeeProfile updateEmployeeStatus(Long id, boolean active);
    EmployeeProfile getEmployeeById(Long id);
    List<EmployeeProfile> getAllEmployees();
}
