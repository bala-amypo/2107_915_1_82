package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "productivity_metrics")
public class ProductivityMetricRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String employeeId;
    private double hoursWorked;
    private int tasksCompleted;
    private int meetings;
    private double score;

    private LocalDate date = LocalDate.now();

    // getters & setters
    public Long getId() { return id; }
    public String getEmployeeId() { return employeeId; }
    public void setEmployeeId(String employeeId) { this.employeeId = employeeId; }

    public double getHoursWorked() { return hoursWorked; }
    public void setHoursWorked(double hoursWorked) { this.hoursWorked = hoursWorked; }

    public int getTasksCompleted() { return tasksCompleted; }
    public void setTasksCompleted(int tasksCompleted) { this.tasksCompleted = tasksCompleted; }

    public int getMeetings() { return meetings; }
    public void setMeetings(int meetings) { this.meetings = meetings; }

    public double getScore() { return score; }
    public void setScore(double score) { this.score = score; }

    public LocalDate getDate() { return date; }
}
