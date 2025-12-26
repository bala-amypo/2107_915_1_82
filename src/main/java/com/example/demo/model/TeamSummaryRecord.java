package com.example.demo.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "team_summary_records", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"teamName", "summaryDate"})
})
public class TeamSummaryRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String teamName;

    private LocalDate summaryDate;

    private Double avgHoursLogged;

    private Double avgTasksCompleted;

    private Double avgScore;

    private Integer anomalyCount;

    private LocalDateTime generatedAt;

    public TeamSummaryRecord() {
    }

    public TeamSummaryRecord(String teamName, LocalDate summaryDate,
                             Double avgHoursLogged, Double avgTasksCompleted,
                             Double avgScore, Integer anomalyCount) {
        this.teamName = teamName;
        this.summaryDate = summaryDate;
        this.avgHoursLogged = avgHoursLogged;
        this.avgTasksCompleted = avgTasksCompleted;
        this.avgScore = avgScore;
        this.anomalyCount = anomalyCount;
    }

    @PrePersist
    protected void onCreate() {
        this.generatedAt = LocalDateTime.now();
    }

    // Getters and setters omitted for brevity
    // ...
}
