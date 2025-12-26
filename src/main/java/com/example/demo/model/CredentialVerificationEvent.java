package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "credential_verification_events")
public class CredentialVerificationEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long credentialId;
    private LocalDateTime verifiedAt;
    private String result;
    private String details;

    public CredentialVerificationEvent() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
}
