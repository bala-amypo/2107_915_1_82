package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.HashSet;

@Entity
@Table(name = "employee_profiles", uniqueConstraints = {
        @UniqueConstraint(columnNames = "employeeId"),
        @UniqueConstraint(columnNames = "email")
})
public class EmployeeProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String employeeId; // External employee identifier (unique)

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false, unique = true)
    private String email;

    private String teamName;

    private String role;

    private Boolean active = true;

    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "employeeProfile", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private Set<ProductivityMetricRecord> metrics = new HashSet<>();

    @OneToMany(mappedBy = "employeeProfile", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private Set<Credential> credentials = new HashSet<>();

    public EmployeeProfile() {
    }

    public EmployeeProfile(String employeeId, String fullName, String email, String teamName, String role, Boolean active) {
        this.employeeId = employeeId;
        this.fullName = fullName;
        this.email = email;
        this.teamName = teamName;
        this.role = role;
        this.active = active;
    }

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    // Getters and setters omitted for brevity (include all fields)
    // ...
}
