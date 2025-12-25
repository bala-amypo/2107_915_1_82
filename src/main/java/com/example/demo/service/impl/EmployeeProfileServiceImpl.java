package com.example.demo.service.impl;

import com.example.demo.model.EmployeeProfile;
import com.example.demo.repository.EmployeeProfileRepository;
import com.example.demo.service.EmployeeProfileService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeProfileServiceImpl implements EmployeeProfileService {

    private final EmployeeProfileRepository repo;

    public EmployeeProfileServiceImpl(EmployeeProfileRepository repo) {
        this.repo = repo;
    }

    public EmployeeProfile createEmployee(EmployeeProfile e) {
        return repo.save(e);
    }

    public EmployeeProfile updateEmployee(Long id, EmployeeProfile e) {
        e.setActive(true);
        return repo.save(e);
    }

    public EmployeeProfile updateEmployeeStatus(Long id, boolean active) {
        EmployeeProfile e = repo.findById(id).orElseThrow();
        e.setActive(active);
        return repo.save(e);
    }

    public EmployeeProfile getEmployeeById(Long id) {
        return repo.findById(id).orElseThrow();
    }

    public List<EmployeeProfile> getAllEmployees() {
        return repo.findAll();
    }
}
