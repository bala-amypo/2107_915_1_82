package com.example.demo.controller;

import com.example.demo.model.EmployeeProfile;
import com.example.demo.service.EmployeeProfileService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeProfileController {

    private final EmployeeProfileService service;

    public EmployeeProfileController(EmployeeProfileService service) {
        this.service = service;
    }

    // CREATE
    @PostMapping
    public EmployeeProfile create(@RequestBody EmployeeProfile employee) {
        return service.createEmployee(employee);
    }

    // READ BY ID
    @GetMapping("/{id}")
    public EmployeeProfile getById(@PathVariable Long id) {
        return service.getEmployeeById(id);
    }

    // READ ALL
    @GetMapping
    public List<EmployeeProfile> getAll() {
        return service.getAllEmployees();
    }

    // UPDATE FULL
    @PutMapping("/{id}")
    public EmployeeProfile update(
            @PathVariable Long id,
            @RequestBody EmployeeProfile employee) {
        return service.updateEmployee(id, employee);
    }

    // UPDATE STATUS
    @PutMapping("/{id}/status")
    public EmployeeProfile updateStatus(
            @PathVariable Long id,
            @RequestParam boolean active) {
        return service.updateEmployeeStatus(id, active);
    }
}
