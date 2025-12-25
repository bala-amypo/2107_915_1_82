package com.example.demo.controller;

import com.example.demo.model.EmployeeProfile;
import com.example.demo.service.EmployeeProfileService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeProfileController {

    private final EmployeeProfileService service;

    public EmployeeProfileController(EmployeeProfileService service) {
        this.service = service;
    }

    @PostMapping
    public EmployeeProfile create(@RequestBody EmployeeProfile e) {
        return service.createEmployee(e);
    }

    @PutMapping("/{id}")
    public EmployeeProfile update(@PathVariable Long id, @RequestBody EmployeeProfile e) {
        return service.updateEmployee(id, e);
    }

    @PutMapping("/{id}/status")
    public EmployeeProfile status(@PathVariable Long id, @RequestParam boolean active) {
        return service.updateEmployeeStatus(id, active);
    }

    @GetMapping
    public List<EmployeeProfile> all() {
        return service.getAllEmployees();
    }
}
