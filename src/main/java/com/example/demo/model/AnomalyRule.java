package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class AnomalyRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ruleName;
    private double threshold;
    private boolean active = true;

    public Long getId() { return id; }
    public String getRuleName() { return ruleName; }
    public void setRuleName(String ruleName) { this.ruleName = ruleName; }
    public double getThreshold() { return threshold; }
    public void setThreshold(double threshold) { this.threshold = threshold; }
    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }
}
