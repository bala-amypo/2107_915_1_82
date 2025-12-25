package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class AnomalyFlagRecord {

    @Id
    @GeneratedValue
    private Long id;

    private String ruleCode;
    private String severity;
    private String details;
    private boolean resolved = false;

    public AnomalyFlagRecord() {}

    public String getRuleCode() { return ruleCode; }
    public void setRuleCode(String ruleCode) { this.ruleCode = ruleCode; }

    public String getSeverity() { return severity; }
    public void setSeverity(String severity) { this.severity = severity; }

    public String getDetails() { return details; }
    public void setDetails(String details) { this.details = details; }

    public boolean getResolved() { return resolved; }
    public void setResolved(boolean resolved) { this.resolved = resolved; }
}
