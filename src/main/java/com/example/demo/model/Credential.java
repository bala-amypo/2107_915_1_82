package com.example.demo.model;

import java.time.LocalDateTime;

public class Credential {

    private Long id;
    private Long employeeId;
    private String credentialId;
    private String issuer;
    private LocalDateTime issuedAt;
    private LocalDateTime expiresAt;
    private String status;
    private String metadataJson;

    public Credential() {}

    public Long getEmployeeId() { return employeeId; }
    public void setEmployeeId(Long employeeId) { this.employeeId = employeeId; }

    public String getCredentialId() { return credentialId; }
    public void setCredentialId(String credentialId) { this.credentialId = credentialId; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
