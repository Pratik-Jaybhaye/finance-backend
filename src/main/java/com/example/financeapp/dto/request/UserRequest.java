package com.example.financeapp.dto.request;
import jakarta.validation.constraints.*;
public class UserRequest {

        @NotBlank
    private String name;

    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String password;

    @NotNull
    private Long roleId;
}
