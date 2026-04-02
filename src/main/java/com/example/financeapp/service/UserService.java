package com.example.financeapp.service;
import java.util.List;
import com.example.financeapp.dto.request.UserRequest;
import com.example.financeapp.dto.response.UserResponse;

public interface UserService {
     UserResponse createUser(UserRequest request);

    List<UserResponse> getAllUsers();

    UserResponse updateUser(Long id, UserRequest request);

    void deleteUser(Long id);

}
