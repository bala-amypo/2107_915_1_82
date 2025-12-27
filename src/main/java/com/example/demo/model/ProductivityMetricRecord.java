package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "productivity_metrics")
public class ProductivityMetricRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long employeeId;

    private LocalDate date;

    private Double hoursLogged;
    private Double tasksCompleted;
    private Double meetingsAttended;

    private Double productivityScore;

    @Column(columnDefinition = "TEXT")
    private String rawDataJson;

    /* ================= GETTERS ================= */

    public Long getId() {
        return id;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public LocalDate getDate() {
        return date;
    }

    public Double getHoursLogged() {
        return hoursLogged;
    }

    public Double getTasksCompleted() {
        return tasksCompleted;
    }

    public Double getMeetingsAttended() {
        return meetingsAttended;
    }

    public Double getProductivityScore() {
        return productivityScore;
    }

    public String getRawDataJson() {
        return rawDataJson;
    }

    /* ================= SETTERS ================= */

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    // 🔑 OVERLOADED SETTERS (THIS IS THE FIX)

    public void setHoursLogged(double hoursLogged) {
        this.hoursLogged = hoursLogged;
    }

    public void setTasksCompleted(int tasksCompleted) {
        this.tasksCompleted = (double) tasksCompleted;
    }

    public void setMeetingsAttended(int meetingsAttended) {
        this.meetingsAttended = (double) meetingsAttended;
    }

    public void setProductivityScore(double productivityScore) {
        this.productivityScore = productivityScore;
    }

    public void setRawDataJson(String rawDataJson) {
        this.rawDataJson = rawDataJson;
    }
}
