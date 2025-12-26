package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class AnomalyFlagRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ruleCode;
    private String severity;
    private String details;
    private Boolean resolved = false;

    public Boolean getResolved() {
        return resolved;
    }

    public void setResolved(Boolean resolved) {
        this.resolved = resolved;
    }

    public String getRuleCode() { return ruleCode; }
    public void setRuleCode(String ruleCode) { this.ruleCode = ruleCode; }

    public String getSeverity() { return severity; }
    public void setSeverity(String severity) { this.severity = severity; }

    public String getDetails() { return details; }
    public void setDetails(String details) { this.details = details; }
}
