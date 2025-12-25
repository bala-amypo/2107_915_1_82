package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "team_summary")
public class TeamSummaryRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String teamName;
    private int totalEmployees;
    private double averageProductivity;
    private int anomalyCount;

    public TeamSummaryRecord() {}

    public TeamSummaryRecord(String teamName, int totalEmployees,
                             double averageProductivity, int anomalyCount) {
        this.teamName = teamName;
        this.totalEmployees = totalEmployees;
        this.averageProductivity = averageProductivity;
        this.anomalyCount = anomalyCount;
    }

    public Long getId() {
        return id;
    }

    public String getTeamName() {
        return teamName;
    }

    public int getTotalEmployees() {
        return totalEmployees;
    }

    public double getAverageProductivity() {
        return averageProductivity;
    }

    public int getAnomalyCount() {
        return anomalyCount;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public void setTotalEmployees(int totalEmployees) {
        this.totalEmployees = totalEmployees;
    }

    public void setAverageProductivity(double averageProductivity) {
        this.averageProductivity = averageProductivity;
    }

    public void setAnomalyCount(int anomalyCount) {
        this.anomalyCount = anomalyCount;
    }
}
