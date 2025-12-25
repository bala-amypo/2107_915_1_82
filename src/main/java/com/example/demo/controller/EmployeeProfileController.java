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

    @PostMapping
    public EmployeeProfile create(@RequestBody EmployeeProfile emp) {
        return service.createEmployee(emp);
    }

    @GetMapping("/{id}")
    public EmployeeProfile getById(@PathVariable Long id) {
        return service.getEmployeeById(id);
    }

    @PutMapping("/{id}")
    public EmployeeProfile update(@PathVariable Long id,
                                  @RequestBody EmployeeProfile emp) {
        return service.updateEmployee(id, emp);
    }

    @PutMapping("/{id}/deactivate")
    public EmployeeProfile deactivate(@PathVariable Long id) {
        return service.updateEmployeeStatus(id, false);
    }
}
