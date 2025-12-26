package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "anomaly_rules", uniqueConstraints = {
        @UniqueConstraint(columnNames = "ruleCode")
})
public class AnomalyRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String ruleCode;

    @Column(length = 512)
    private String description;

    private String thresholdType;

    private Double thresholdValue;

    private Boolean active = true;

    public AnomalyRule() {
    }

    public AnomalyRule(String ruleCode, String description, String thresholdType, Double thresholdValue, Boolean active) {
        this.ruleCode = ruleCode;
        this.description = description;
        this.thresholdType = thresholdType;
        this.thresholdValue = thresholdValue;
        this.active = active;
    }

    // Getters and setters omitted for brevity
    // ...
}
