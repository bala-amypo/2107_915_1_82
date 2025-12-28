package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "employee_profiles")
public class EmployeeProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String employeeId;

    private String fullName;
    private String email;
    private String teamName;

    private Boolean active = true;

    /* ===== REQUIRED BY TESTS ===== */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {   // ✅ REQUIRED
        this.id = id;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getFullName() {   // ✅ REQUIRED
        return fullName;
    }

    public void setFullName(String fullName) { // ✅ REQUIRED
        this.fullName = fullName;
    }

    public String getEmail() {      // ✅ REQUIRED
        return email;
    }

    public void setEmail(String email) { // ✅ REQUIRED
        this.email = email;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Boolean getActive() {    // ✅ REQUIRED
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
