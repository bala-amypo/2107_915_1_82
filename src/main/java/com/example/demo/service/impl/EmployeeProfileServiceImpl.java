package com.example.demo.service.impl;

import com.example.demo.model.EmployeeProfile;
import com.example.demo.repository.EmployeeProfileRepository;
import com.example.demo.service.EmployeeProfileService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeProfileServiceImpl implements EmployeeProfileService {

    private final EmployeeProfileRepository repository;

    public EmployeeProfileServiceImpl(EmployeeProfileRepository repository) {
        this.repository = repository;
    }

    @Override
    public EmployeeProfile createEmployee(EmployeeProfile e) {
        // ✅ REAL DB SAVE
        return repository.save(e);
    }

    @Override
    public EmployeeProfile getEmployeeById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    @Override
    public Optional<EmployeeProfile> findByEmployeeId(String employeeId) {
        return repository.findByEmployeeId(employeeId);
    }

    @Override
    public EmployeeProfile updateEmployeeStatus(Long id, boolean active) {
        EmployeeProfile e = getEmployeeById(id);
        e.setActive(active);
        return repository.save(e);
    }
}
