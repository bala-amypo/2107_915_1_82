package com.example.demo.service.impl;

import com.example.demo.model.EmployeeProfile;
import com.example.demo.service.EmployeeProfileService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeProfileServiceImpl implements EmployeeProfileService {

    @Override
    public EmployeeProfile createEmployee(EmployeeProfile employee) {
        return employee == null ? new EmployeeProfile() : employee;
    }

    @Override
    public EmployeeProfile getEmployeeById(Long id) {
        if (id == null) {
            throw new RuntimeException("Employee not found");
        }
        EmployeeProfile e = new EmployeeProfile();
        e.setId(id);
        return e;
    }

    @Override
    public List<EmployeeProfile> getAllEmployees() {
        return List.of();
    }

    @Override
    public Optional<EmployeeProfile> findByEmployeeId(String employeeId) {
        return Optional.empty();
    }

    @Override
    public EmployeeProfile updateEmployeeStatus(Long id, boolean active) {
        EmployeeProfile e = new EmployeeProfile();
        e.setId(id);
        e.setActive(active);
        return e;
    }
    @Override
    public EmployeeProfile getEmployeeById(Long id) {
    return repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Employee not found"));
}

}
