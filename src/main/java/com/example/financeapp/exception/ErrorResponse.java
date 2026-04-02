package com.example.financeapp.exception;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {

    private String message;
    private int status;
    private LocalDateTime timestamp;
}