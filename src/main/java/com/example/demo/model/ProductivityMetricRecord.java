package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class ProductivityMetricRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String employeeId;
    private double hoursWorked;
    private int tasksCompleted;
    private int meetingsAttended;
    private double productivityScore;
    private LocalDate date = LocalDate.now();

    // getters & setters
    public Long getId() { return id; }
    public String getEmployeeId() { return employeeId; }
    public void setEmployeeId(String employeeId) { this.employeeId = employeeId; }
    public double getHoursWorked() { return hoursWorked; }
    public void setHoursWorked(double hoursWorked) { this.hoursWorked = hoursWorked; }
    public int getTasksCompleted() { return tasksCompleted; }
    public void setTasksCompleted(int tasksCompleted) { this.tasksCompleted = tasksCompleted; }
    public int getMeetingsAttended() { return meetingsAttended; }
    public void setMeetingsAttended(int meetingsAttended) { this.meetingsAttended = meetingsAttended; }
    public double getProductivityScore() { return productivityScore; }
    public void setProductivityScore(double productivityScore) { this.productivityScore = productivityScore; }
    public LocalDate getDate() { return date; }
}
