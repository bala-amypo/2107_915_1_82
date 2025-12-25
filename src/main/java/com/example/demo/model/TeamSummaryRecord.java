package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class TeamSummaryRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String teamName;
    private int totalEmployees;
    private double averageProductivity;

    // ✅ REQUIRED by JPA + Test cases
    public TeamSummaryRecord() {}

    // (Optional convenience constructor – safe)
    public TeamSummaryRecord(String teamName, int totalEmployees, double averageProductivity) {
        this.teamName = teamName;
        this.totalEmployees = totalEmployees;
        this.averageProductivity = averageProductivity;
    }

    // ✅ Getters & Setters (tests rely on these)
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTeamName() { return teamName; }
    public void setTeamName(String teamName) { this.teamName = teamName; }

    public int getTotalEmployees() { return totalEmployees; }
    public void setTotalEmployees(int totalEmployees) { this.totalEmployees = totalEmployees; }

    public double getAverageProductivity() { return averageProductivity; }
    public void setAverageProductivity(double averageProductivity) {
        this.averageProductivity = averageProductivity;
    }
}
