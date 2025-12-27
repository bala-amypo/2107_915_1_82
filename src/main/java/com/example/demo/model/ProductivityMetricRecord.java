package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "productivity_metrics")
public class ProductivityMetricRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Used in many tests
    private Long employeeId;

    private LocalDate date;

    // MUST be Double (tests pass double literals)
    private Double hoursLogged;
    private Double tasksCompleted;
    private Double meetingsAttended;

    // Score must always exist & be numeric
    private Double productivityScore;

    @Column(columnDefinition = "TEXT")
    private String rawDataJson;

    public ProductivityMetricRecord() {}

    // ---------------- ID ----------------
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // ---------------- EMPLOYEE ----------------
    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    // ---------------- DATE ----------------
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    // ---------------- METRICS ----------------
    public Double getHoursLogged() {
        return hoursLogged;
    }

    public void setHoursLogged(Double hoursLogged) {
        this.hoursLogged = hoursLogged;
    }

    public Double getTasksCompleted() {
        return tasksCompleted;
    }

    public void setTasksCompleted(Double tasksCompleted) {
        this.tasksCompleted = tasksCompleted;
    }

    public Double getMeetingsAttended() {
        return meetingsAttended;
    }

    public void setMeetingsAttended(Double meetingsAttended) {
        this.meetingsAttended = meetingsAttended;
    }

    // ---------------- SCORE ----------------
    public Double getProductivityScore() {
        return productivityScore;
    }

    public void setProductivityScore(Double productivityScore) {
        this.productivityScore = productivityScore;
    }

    // ---------------- RAW JSON ----------------
    public String getRawDataJson() {
        return rawDataJson;
    }

    public void setRawDataJson(String rawDataJson) {
        this.rawDataJson = rawDataJson;
    }
}
