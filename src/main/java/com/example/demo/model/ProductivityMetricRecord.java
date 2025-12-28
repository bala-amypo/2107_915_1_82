package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(
    name = "productivity_metrics",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = {"employee_id", "date"})
    }
)
public class ProductivityMetricRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "employee_id", nullable = false)
    private Long employeeId;

    private LocalDate date;

    // ===== CORE METRICS =====
    private Double hoursLogged = 0.0;
    private Integer tasksCompleted = 0;
    private Integer meetingsAttended = 0;

    // ===== SCORE =====
    private Double productivityScore = 0.0;

    @Lob
    private String rawDataJson;

    /* ================= GETTERS / SETTERS ================= */

    public Long getId() { return id; }

    public Long getEmployeeId() { return employeeId; }
    public void setEmployeeId(Long employeeId) { this.employeeId = employeeId; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    // 🔥 REQUIRED BY TESTS
    public Double getHoursLogged() { return hoursLogged; }
    public void setHoursLogged(double hoursLogged) {
        this.hoursLogged = Math.max(0, hoursLogged);
    }

    public Integer getTasksCompleted() { return tasksCompleted; }
    public void setTasksCompleted(Integer tasksCompleted) {
        this.tasksCompleted = Math.max(0, tasksCompleted);
    }

    public Integer getMeetingsAttended() { return meetingsAttended; }
    public void setMeetingsAttended(Integer meetingsAttended) {
        this.meetingsAttended = Math.max(0, meetingsAttended);
    }

    // 🔥 REQUIRED BY TESTS
    public Double getProductivityScore() { return productivityScore; }
    public void setProductivityScore(double score) {
        this.productivityScore = Math.max(0, score);
    }

    public String getRawDataJson() { return rawDataJson; }
    public void setRawDataJson(String rawDataJson) { this.rawDataJson = rawDataJson; }
}
