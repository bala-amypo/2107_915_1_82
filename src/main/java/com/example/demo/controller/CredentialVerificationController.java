package com.example.demo.controller;

import com.example.demo.dto.CredentialRequestDto;
import com.example.demo.dto.CredentialStatusDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/credentials")
public class CredentialVerificationController {

    @PostMapping("/verify")
    public CredentialStatusDto verify(@RequestBody CredentialRequestDto request) {
        return new CredentialStatusDto("VERIFIED");
    }
}
