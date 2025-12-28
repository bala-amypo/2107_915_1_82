package com.example.demo.service.impl;

import com.example.demo.model.EmployeeProfile;
import com.example.demo.repository.EmployeeProfileRepository;
import com.example.demo.service.EmployeeProfileService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeProfileServiceImpl implements EmployeeProfileService {

    private final EmployeeProfileRepository repository;

    public EmployeeProfileServiceImpl(EmployeeProfileRepository repository) {
        this.repository = repository;
    }

    @Override
    public EmployeeProfile createEmployee(EmployeeProfile employee) {
        return repository.save(employee);
    }

    @Override
    public List<EmployeeProfile> getAllEmployees() {
        return repository.findAll();
    }

    @Override
    public Optional<EmployeeProfile> getEmployeeById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Optional<EmployeeProfile> findByEmployeeId(String employeeId) {
        return repository.findByEmployeeId(employeeId);
    }

    @Override
    public EmployeeProfile updateEmployee(EmployeeProfile employee) {
        return repository.save(employee);
    }

    @Override
    public EmployeeProfile updateEmployeeStatus(Long id, boolean active) {
        EmployeeProfile emp = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        emp.setActive(active);
        return repository.save(emp);
    }

    @Override
    public void deleteEmployee(Long id) {
        repository.deleteById(id);
    }
}
