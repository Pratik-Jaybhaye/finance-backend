package com.example.financeapp.dto.request;
import jakarta.validation.constraints.*;
import java.time.LocalDate;
public class RecordRequest {
     @NotNull
    private Double amount;

    @NotBlank
    private String type; 

    @NotBlank
    private String category;

    @NotNull
    private LocalDate date;

    private String description;
}
