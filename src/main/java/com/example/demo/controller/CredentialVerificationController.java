package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/credentials")
public class CredentialVerificationController {

    @PostMapping
    public String register() {
        return "credential-registered";
    }

    @PostMapping("/{credentialId}/verify")
    public String verify(@PathVariable String credentialId) {
        return "verified";
    }
}
