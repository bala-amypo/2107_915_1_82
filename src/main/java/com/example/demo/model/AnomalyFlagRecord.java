package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class AnomalyFlagRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String employeeId;
    private String reason;
    private boolean resolved = false;

    public Long getId() { return id; }
    public String getEmployeeId() { return employeeId; }
    public void setEmployeeId(String employeeId) { this.employeeId = employeeId; }
    public String getReason() { return reason; }
    public void setReason(String reason) { this.reason = reason; }
    public boolean isResolved() { return resolved; }
    public void setResolved(boolean resolved) { this.resolved = resolved; }
}
