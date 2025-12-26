package com.example.demo.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.HashSet;

@Entity
@Table(name = "productivity_metric_records", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"employee_profile_id", "date"})
})
public class ProductivityMetricRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_profile_id", nullable = false)
    private EmployeeProfile employeeProfile;

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    private Double hoursLogged;

    @Column(nullable = false)
    private Integer tasksCompleted;

    @Column(nullable = false)
    private Integer meetingsAttended;

    private Double productivityScore;

    @Column(columnDefinition = "TEXT")
    private String rawDataJson;

    private LocalDateTime submittedAt;

    @OneToMany(mappedBy = "metric", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<AnomalyFlagRecord> anomalyFlags = new HashSet<>();

    public ProductivityMetricRecord() {
    }

    public ProductivityMetricRecord(EmployeeProfile employeeProfile, LocalDate date,
                                    Double hoursLogged, Integer tasksCompleted, Integer meetingsAttended,
                                    String rawDataJson) {
        this.employeeProfile = employeeProfile;
        this.date = date;
        this.hoursLogged = hoursLogged;
        this.tasksCompleted = tasksCompleted;
        this.meetingsAttended = meetingsAttended;
        this.rawDataJson = rawDataJson;
    }

    @PrePersist
    protected void onCreate() {
        this.submittedAt = LocalDateTime.now();
    }

    // Getters and setters omitted for brevity
    // ...
}
