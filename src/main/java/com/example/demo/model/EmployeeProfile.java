package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class EmployeeProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String employeeId;
    private String name;
    private String email;
    private boolean active = true;
    private String team;

    // getters & setters
    public Long getId() { return id; }
    public String getEmployeeId() { return employeeId; }
    public void setEmployeeId(String employeeId) { this.employeeId = employeeId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }
    public String getTeam() { return team; }
    public void setTeam(String team) { this.team = team; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}
