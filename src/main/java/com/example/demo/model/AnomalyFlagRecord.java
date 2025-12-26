package com.example.demo.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "anomaly_flag_records")
public class AnomalyFlagRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_profile_id", nullable = false)
    private EmployeeProfile employeeProfile;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "metric_id", nullable = false)
    private ProductivityMetricRecord metric;

    @Column(nullable = false)
    private String ruleCode;

    private String severity;

    @Column(length = 512)
    private String details;

    private LocalDateTime flaggedAt;

    private Boolean resolved = false;

    public AnomalyFlagRecord() {
    }

    public AnomalyFlagRecord(EmployeeProfile employeeProfile, ProductivityMetricRecord metric,
                             String ruleCode, String severity, String details) {
        this.employeeProfile = employeeProfile;
        this.metric = metric;
        this.ruleCode = ruleCode;
        this.severity = severity;
        this.details = details;
    }

    @PrePersist
    protected void onCreate() {
        this.flaggedAt = LocalDateTime.now();
        if (this.resolved == null) {
            this.resolved = false;
        }
    }

    // Getters and setters omitted for brevity
    // ...
}
