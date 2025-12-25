package com.example.demo.service.impl;

import com.example.demo.model.EmployeeProfile;
import com.example.demo.service.EmployeeProfileService;
import java.util.Optional;

public class EmployeeProfileServiceImpl implements EmployeeProfileService {

    public EmployeeProfile createEmployee(EmployeeProfile e) { return e; }
    public EmployeeProfile getEmployeeById(Long id) { return new EmployeeProfile(); }
    public EmployeeProfile updateEmployeeStatus(Long id, boolean active) {
        EmployeeProfile e = new EmployeeProfile();
        e.setActive(active);
        return e;
    }
    public Optional<EmployeeProfile> findByEmployeeId(String empId) {
        return Optional.empty();
    }
}
