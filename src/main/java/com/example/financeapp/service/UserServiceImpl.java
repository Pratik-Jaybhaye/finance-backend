package com.example.financeapp.service;

import org.springframework.stereotype.Service;

import com.example.financeapp.dto.request.UserRequest;
import com.example.financeapp.dto.response.UserResponse;
import com.example.financeapp.repository.RoleRepository;
import com.example.financeapp.repository.UserRepository;
@Service
public class UserServiceImpl implements UserService {
   private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

      @Override
    public UserResponse createUser(UserRequest request) {

        Role role = roleRepository.findById(request.getRoleId())
                .orElseThrow(() -> new RuntimeException("Role not found"));

        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword()); 
        user.setRole(role);
        user.setStatus(Status.ACTIVE);

        userRepository.save(user);

        return mapToResponse(user);
    }

     private UserResponse mapToResponse(User user) {
        UserResponse res = new UserResponse();
        res.setId(user.getId());
        res.setName(user.getName());
        res.setEmail(user.getEmail());
        res.setRole(user.getRole().getName().name());
        res.setStatus(user.getStatus().name());
        return res;
    }
}
