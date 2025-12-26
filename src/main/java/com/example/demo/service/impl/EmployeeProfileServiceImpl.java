package com.example.demo.service.impl;

import com.example.demo.model.EmployeeProfile;
import com.example.demo.repository.EmployeeProfileRepository;
import com.example.demo.service.EmployeeProfileService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeProfileServiceImpl implements EmployeeProfileService {

    @Autowired
    private EmployeeProfileRepository repo;

    public EmployeeProfile createEmployee(EmployeeProfile e) {
        return repo.save(e);
    }

    public EmployeeProfile getEmployeeById(Long id) {
        return repo.findById(id).orElseThrow();
    }

    public List<EmployeeProfile> getAllEmployees() {
        return repo.findAll();
    }

    public Optional<EmployeeProfile> findByEmployeeId(String employeeId) {
        return repo.findByEmployeeId(employeeId);
    }

    public EmployeeProfile updateEmployeeStatus(Long id, boolean active) {
        EmployeeProfile e = getEmployeeById(id);
        e.setActive(active);
        return repo.save(e);
    }
}
