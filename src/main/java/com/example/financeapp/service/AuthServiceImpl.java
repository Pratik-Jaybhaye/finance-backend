package com.example.financeapp.service;

import org.springframework.stereotype.Service;

import com.example.financeapp.dto.request.AuthRequest;
import com.example.financeapp.dto.response.AuthResponse;
import com.example.financeapp.entity.User;
import com.example.financeapp.exception.BadRequestException;
import com.example.financeapp.exception.ResourceNotFoundException;
import com.example.financeapp.repository.UserRepository;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;

    public AuthServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

     @Override
    public AuthResponse login(AuthRequest request) {

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        if (!user.getPassword().equals(request.getPassword())) {
           throw new BadRequestException("Invalid password");
        }

         return new AuthResponse(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getRole().getName().name(),
                null 
        );
    }

}
