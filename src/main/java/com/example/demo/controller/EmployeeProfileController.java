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

    // POST – create employee
    @PostMapping
    public EmployeeProfile createEmployee(@RequestBody EmployeeProfile employee) {
        return service.createEmployee(employee);
    }

    // GET – get employee by id
    @GetMapping("/{id}")
    public EmployeeProfile getEmployee(@PathVariable Long id) {
        return service.getEmployeeById(id);
    }

    // GET – all employees
    @GetMapping
    public List<EmployeeProfile> getAllEmployees() {
        return service.getAllEmployees();
    }

    // PUT – update employee details
    @PutMapping("/{id}")
    public EmployeeProfile updateEmployee(
            @PathVariable Long id,
            @RequestBody EmployeeProfile employee) {
        return service.updateEmployee(id, employee);
    }

    // PUT – activate / deactivate employee
    @PutMapping("/{id}/status")
    public EmployeeProfile updateStatus(
            @PathVariable Long id,
            @RequestParam boolean active) {
        return service.updateEmployeeStatus(id, active);
    }
}
