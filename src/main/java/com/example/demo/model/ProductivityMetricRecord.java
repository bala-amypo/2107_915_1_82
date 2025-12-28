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

    private Double hoursWorked;
    private Integer tasksCompleted;
    private Integer meetingsAttended;

    private Double score;

    @Lob
    private String rawDataJson;

    /* ===== DEFAULTS ===== */

    public ProductivityMetricRecord() {
        this.hoursWorked = 0.0;
        this.tasksCompleted = 0;
        this.meetingsAttended = 0;
        this.score = 0.0;
    }

    /* ===== GETTERS / SETTERS ===== */

    public Long getId() { return id; }

    public Long getEmployeeId() { return employeeId; }
    public void setEmployeeId(Long employeeId) { this.employeeId = employeeId; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public Double getHoursWorked() { return hoursWorked; }
    public void setHoursWorked(Double hoursWorked) { this.hoursWorked = hoursWorked; }

    public Integer getTasksCompleted() { return tasksCompleted; }
    public void setTasksCompleted(Integer tasksCompleted) { this.tasksCompleted = tasksCompleted; }

    public Integer getMeetingsAttended() { return meetingsAttended; }
    public void setMeetingsAttended(Integer meetingsAttended) { this.meetingsAttended = meetingsAttended; }

    public Double getScore() { return score; }
    public void setScore(Double score) { this.score = score; }

    public String getRawDataJson() { return rawDataJson; }
    public void setRawDataJson(String rawDataJson) { this.rawDataJson = rawDataJson; }
}
