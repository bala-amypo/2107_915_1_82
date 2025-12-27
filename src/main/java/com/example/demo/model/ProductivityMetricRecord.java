package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "productivity_metrics")
public class ProductivityMetricRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer hoursLogged;
    private Integer tasksCompleted;
    private Integer meetingsAttended;

    private Double productivityScore = 0.0;

    @PrePersist
    @PreUpdate
    public void normalizeScore() {
        if (productivityScore == null
                || Double.isNaN(productivityScore)
                || productivityScore < 0) {
            productivityScore = 0.0;
        }
        if (productivityScore > 100) {
            productivityScore = 100.0;
        }
    }

    // getters & setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Integer getHoursLogged() { return hoursLogged; }
    public void setHoursLogged(Integer hoursLogged) { this.hoursLogged = hoursLogged; }

    public Integer getTasksCompleted() { return tasksCompleted; }
    public void setTasksCompleted(Integer tasksCompleted) { this.tasksCompleted = tasksCompleted; }

    public Integer getMeetingsAttended() { return meetingsAttended; }
    public void setMeetingsAttended(Integer meetingsAttended) { this.meetingsAttended = meetingsAttended; }

    public Double getProductivityScore() { return productivityScore; }
    public void setProductivityScore(Double productivityScore) {
        this.productivityScore = productivityScore;
    }
}
