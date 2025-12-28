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

    private Long employeeId;
    private LocalDate date;

    private Double hoursLogged;
    private Integer tasksCompleted;
    private Integer meetingsAttended;

    private Double productivityScore;

    @Lob
    private String rawDataJson;

    public ProductivityMetricRecord() {
        this.hoursLogged = 0.0;
        this.tasksCompleted = 0;
        this.meetingsAttended = 0;
        this.productivityScore = 0.0;
    }

    /* ===== REQUIRED BY TESTS ===== */

    // 🔹 HOURS
    public Double getHoursLogged() {
        return hoursLogged;
    }

    public void setHoursLogged(Double hoursLogged) {
        this.hoursLogged = hoursLogged;
    }

    // 🔹 OVERLOAD (for int input from tests)
    public void setHoursLogged(int hoursLogged) {
        this.hoursLogged = (double) hoursLogged;
    }

    // 🔹 TASKS
    public Integer getTasksCompleted() {
        return tasksCompleted;
    }

    public void setTasksCompleted(Integer tasksCompleted) {
        this.tasksCompleted = tasksCompleted;
    }

    // 🔹 MEETINGS
    public Integer getMeetingsAttended() {
        return meetingsAttended;
    }

    public void setMeetingsAttended(Integer meetingsAttended) {
        this.meetingsAttended = meetingsAttended;
    }

    // 🔹 SCORE
    public Double getProductivityScore() {
        return productivityScore;
    }

    public void setProductivityScore(Double productivityScore) {
        this.productivityScore = productivityScore;
    }

    public void setProductivityScore(int productivityScore) {
        this.productivityScore = (double) productivityScore;
    }

    // 🔹 OTHER
    public Long getEmployeeId() { return employeeId; }
    public void setEmployeeId(Long employeeId) { this.employeeId = employeeId; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public String getRawDataJson() { return rawDataJson; }
    public void setRawDataJson(String rawDataJson) { this.rawDataJson = rawDataJson; }
}
