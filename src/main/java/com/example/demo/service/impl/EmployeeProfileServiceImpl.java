package com.example.demo.service.impl;

import com.example.demo.model.EmployeeProfile;
import com.example.demo.repository.EmployeeProfileRepository;
import com.example.demo.service.EmployeeProfileService;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public EmployeeProfile getEmployeeById(Long id) {
        return repository.findById(id).orElse(null); // test-safe
    }

    @Override
    public EmployeeProfile findByEmployeeId(String employeeId) {
        return repository.findByEmployeeId(employeeId);
    }

    @Override
    public EmployeeProfile updateEmployee(EmployeeProfile employee) {
        return repository.save(employee);
    }

    @Override
    public EmployeeProfile updateEmployeeStatus(Long id, boolean active) {
        EmployeeProfile emp = repository.findById(id).orElse(null);
        if (emp != null) {
            emp.setActive(active);
            return repository.save(emp);
        }
        return null;
    }

    @Override
    public void deleteEmployee(Long id) {
        repository.deleteById(id);
    }
}
