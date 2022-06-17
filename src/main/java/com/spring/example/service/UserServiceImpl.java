package com.spring.example.service;

import com.spring.example.dto.product.UserRequest;
import com.spring.example.dto.product.UserResponse;
import com.spring.example.model.UserEntity;
import com.spring.example.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserResponse createOrUpdateUser(UserRequest userRequest, Long id) {
        UserEntity userEntity = userRepository.findById(id).orElse(new UserEntity());
        userEntity.setUsername(userRequest.getUsername());
        userEntity.setEmail(userRequest.getEmail());
        userEntity.setPhoneNumber(userRequest.getPhoneNumber());
        userEntity.setPassword(userRequest.getPassword());
        userEntity.setPassword(userRequest.getPassword());
        userEntity.setLastLoginAt(userRequest.getLastLoginAt());
        userEntity.setStatus(userRequest.getStatus());
        userRepository.save(userEntity);
        return new UserResponse(userEntity);
    }

    @Override
    public List<UserEntity> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public UserResponse findUserById(Long id) {
        Optional<UserEntity> userEntity = userRepository.findById(id);
        return userEntity.map(UserResponse::new).orElse(null);
    }

    @Override
    public String deleteUserById(Long id) {
        userRepository.deleteById(id);
        return "ok";
    }

}
