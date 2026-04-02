package com.example.financeapp.dto.response;

public class AuthResponse {

     private Long userId;
    private String name;
    private String email;
    private String role;

     private String token;

       public AuthResponse(Long userId, String name, String email, String role, String token) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.role = role;
        this.token = token;
    }
}
