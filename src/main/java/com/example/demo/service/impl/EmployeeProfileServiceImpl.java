package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
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
    public EmployeeProfile getEmployeeById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found"));
    }

    @Override
    public List<EmployeeProfile> getAllEmployees() {
        return repository.findAll();
    }

    @Override
    public Optional<EmployeeProfile> findByEmployeeId(String employeeId) {
        return repository.findByEmployeeId(employeeId);
    }

    @Override
    public EmployeeProfile updateEmployeeStatus(Long id, boolean active) {
        EmployeeProfile emp = getEmployeeById(id);
        emp.setActive(active);
        return repository.save(emp);
    }
    @Override
public EmployeeProfile createEmployee(EmployeeProfile employee) {
    if (employee == null) return new EmployeeProfile();
    return employee;
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

}
