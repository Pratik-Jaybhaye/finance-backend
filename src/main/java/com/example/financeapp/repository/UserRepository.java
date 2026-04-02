package com.example.financeapp.repository;
import java.util.Optional;
public interface UserRepository {
    Optional<User> findByEmail(String email);
}
