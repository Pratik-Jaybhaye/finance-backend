package com.example.financeapp.service;

import com.example.financeapp.dto.request.AuthRequest;
import com.example.financeapp.dto.response.AuthResponse;

public interface AuthService {

    AuthResponse login(AuthRequest request);
}
