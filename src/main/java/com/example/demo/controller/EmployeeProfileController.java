package com.example.demo.controller;

import com.example.demo.model.EmployeeProfile;
import com.example.demo.service.EmployeeProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/employees")
public class EmployeeProfileController {

    @Autowired
    private EmployeeProfileService service;

    @PostMapping
    public EmployeeProfile create(@RequestBody EmployeeProfile e) {
        return service.createEmployee(e);
    }

    @GetMapping("/{id}")
    public EmployeeProfile getById(@PathVariable Long id) {
        return service.getEmployeeById(id);
    }

    @GetMapping("/lookup/{employeeId}")
    public Optional<EmployeeProfile> findByEmployeeId(@PathVariable String employeeId) {
        return service.findByEmployeeId(employeeId);
    }

    @PutMapping("/{id}/status")
    public EmployeeProfile updateStatus(
            @PathVariable Long id,
            @RequestParam boolean active) {
        return service.updateEmployeeStatus(id, active);
    }
}
