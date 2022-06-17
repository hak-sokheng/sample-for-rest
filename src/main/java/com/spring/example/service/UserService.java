package com.spring.example.service;

import com.spring.example.dto.product.UserRequest;
import com.spring.example.dto.product.UserResponse;
import com.spring.example.model.UserEntity;

import java.util.List;

public interface UserService {

    UserResponse createOrUpdateUser(UserRequest userRequest, Long id);

    List<UserEntity> findAllUsers();

    UserResponse findUserById(Long id);

    String deleteUserById(Long id);
}
