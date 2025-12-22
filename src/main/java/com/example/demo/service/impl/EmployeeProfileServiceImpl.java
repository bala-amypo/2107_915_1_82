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
    public EmployeeProfile save(EmployeeProfile e) {
        return repo.save(e);
    }

    @Override
    public List<EmployeeProfile> findAll() {
        return repo.findAll();
    }

    @Override
    public Optional<EmployeeProfile> findByEmployeeId(String employeeId) {
        return repo.findByEmployeeId(employeeId);
    }
}
