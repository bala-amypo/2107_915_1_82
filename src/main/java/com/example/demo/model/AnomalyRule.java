package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class AnomalyRule {

    @Id
    @GeneratedValue
    private Long id;

    private String ruleCode;
    private Double thresholdValue;
    private boolean active = true;

    public AnomalyRule() {}

    public String getRuleCode() { return ruleCode; }
    public void setRuleCode(String ruleCode) { this.ruleCode = ruleCode; }

    public Double getThresholdValue() { return thresholdValue; }
    public void setThresholdValue(Double thresholdValue) { this.thresholdValue = thresholdValue; }

    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }
}
