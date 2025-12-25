package com.example.demo.service;

import com.example.demo.model.EmployeeProfile;
import java.util.List;

public interface EmployeeProfileService {

    EmployeeProfile createEmployee(EmployeeProfile employee);

    EmployeeProfile getEmployeeById(Long id);

    EmployeeProfile updateEmployee(Long id, EmployeeProfile employee);

    EmployeeProfile updateEmployeeStatus(Long id, boolean active);

    List<EmployeeProfile> getAllEmployees();
}
