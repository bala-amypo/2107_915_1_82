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
    public EmployeeProfile createEmployee(@RequestBody EmployeeProfile employee) {
        return service.createEmployee(employee);
    }

    @GetMapping
    public List<EmployeeProfile> getAllEmployees() {
        return service.getAllEmployees();
    }

    @GetMapping("/{id}")
    public EmployeeProfile getEmployeeById(@PathVariable Long id) {
        EmployeeProfile emp = service.getEmployeeById(id);
        if (emp == null) {
            throw new RuntimeException("Employee not found");
        }
        return emp;
    }

    @PutMapping
    public EmployeeProfile updateEmployee(@RequestBody EmployeeProfile employee) {
        return service.updateEmployee(employee);
    }

    @PutMapping("/{id}/status")
    public EmployeeProfile updateEmployeeStatus(
            @PathVariable Long id,
            @RequestParam boolean active) {
        return service.updateEmployeeStatus(id, active);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        service.deleteEmployee(id);
    }
}
