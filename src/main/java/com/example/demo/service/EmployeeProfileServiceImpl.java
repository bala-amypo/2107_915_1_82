package com.example.demo.service;

import com.example.demo.model.EmployeeProfile;
import java.util.*;

public interface EmployeeProfileService {

    EmployeeProfile createEmployee(EmployeeProfile e);

    EmployeeProfile getEmployeeById(Long id);

    Optional<EmployeeProfile> findByEmployeeId(String empId);

    EmployeeProfile updateEmployeeStatus(Long id, boolean active);

    EmployeeProfile updateEmployee(Long id, EmployeeProfile e);

    List<EmployeeProfile> getAllEmployees();
}
