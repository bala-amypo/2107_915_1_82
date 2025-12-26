package com.example.demo.dto;

public class AuthResponse {

    private String token;

    public AuthResponseDTO(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}
