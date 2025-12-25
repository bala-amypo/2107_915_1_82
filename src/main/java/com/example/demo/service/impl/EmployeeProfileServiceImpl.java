package com.example.demo.service.impl;

import com.example.demo.model.EmployeeProfile;
import com.example.demo.repository.EmployeeProfileRepository;
import com.example.demo.service.EmployeeProfileService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeProfileServiceImpl implements EmployeeProfileService {

    private final EmployeeProfileRepository repo;

    public EmployeeProfileServiceImpl(EmployeeProfileRepository repo) {
        this.repo = repo;
    }

    @Override
    public EmployeeProfile createEmployee(EmployeeProfile employee) {
        return repo.save(employee);
    }

    @Override
    public EmployeeProfile getEmployeeById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public List<EmployeeProfile> getAllEmployees() {
        return repo.findAll();
    }

    @Override
    public EmployeeProfile updateEmployee(Long id, EmployeeProfile employee) {
        employee.setId(id);
        return repo.save(employee);
    }

    @Override
    public EmployeeProfile updateEmployeeStatus(Long id, boolean active) {
        EmployeeProfile e = repo.findById(id).orElse(null);
        if (e != null) {
            e.setActive(active);
            return repo.save(e);
        }
        return null;
    }

    @Override
    public Optional<EmployeeProfile> findByEmployeeId(String employeeId) {
        return repo.findByEmployeeId(employeeId);
    }
}
