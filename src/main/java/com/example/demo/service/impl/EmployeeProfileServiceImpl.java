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

    @Override
    public EmployeeProfile createEmployee(EmployeeProfile employee) {
        return repo.save(employee);
    }

    @Override
    public EmployeeProfile getEmployeeById(Long id) {
        return repo.findById(id).orElseThrow();
    }

    @Override
    public List<EmployeeProfile> getAllEmployees() {
        return repo.findAll();
    }

    @Override
    public EmployeeProfile updateEmployee(Long id, EmployeeProfile employee) {
        EmployeeProfile e = getEmployeeById(id);
        e.setName(employee.getName());
        e.setEmail(employee.getEmail());
        e.setTeam(employee.getTeam());
        return repo.save(e);
    }

    @Override
    public EmployeeProfile updateEmployeeStatus(Long id, boolean active) {
        EmployeeProfile e = getEmployeeById(id);
        e.setActive(active);
        return repo.save(e);
    }
}
