package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "productivity_metrics")
public class ProductivityMetricRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // REQUIRED BY TESTS
    private Long employeeId;

    private LocalDate date;

    private Integer hoursLogged;
    private Integer tasksCompleted;
    private Integer meetingsAttended;

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
    public Integer getHoursLogged() {
        return hoursLogged;
    }

    public void setHoursLogged(Integer hoursLogged) {
        this.hoursLogged = hoursLogged;
    }

    public Integer getTasksCompleted() {
        return tasksCompleted;
    }

    public void setTasksCompleted(Integer tasksCompleted) {
        this.tasksCompleted = tasksCompleted;
    }

    public Integer getMeetingsAttended() {
        return meetingsAttended;
    }

    public void setMeetingsAttended(Integer meetingsAttended) {
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
