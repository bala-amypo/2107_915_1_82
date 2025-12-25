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

    // ✅ REQUIRED: no-arg constructor (JPA)
    public TeamSummaryRecord() {}

    // ✅ REQUIRED: constructor used by Util + tests
    public TeamSummaryRecord(String teamName, int totalEmployees, double averageProductivity) {
        this.teamName = teamName;
        this.totalEmployees = totalEmployees;
        this.averageProductivity = averageProductivity;
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
}
