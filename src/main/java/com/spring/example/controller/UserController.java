package com.spring.example.controller;

import com.spring.example.dto.product.UserRequest;
import com.spring.example.dto.product.UserResponse;
import com.spring.example.model.UserEntity;
import com.spring.example.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserEntity> findAllUsers() {
        return userService.findAllUsers();
    }

    @PostMapping("/post")
    public UserResponse saveUser(@RequestBody UserRequest userRequest) {
        return userService.createOrUpdateUser(userRequest, 0L);
    }

    @PutMapping("/{id}")
    public UserResponse updateUser(@RequestBody UserRequest userRequest, @PathVariable("id") Long id){
        return userService.createOrUpdateUser(userRequest, id);
    }

    @GetMapping("/{id}")
    public UserResponse findUserById(@PathVariable("id") Long id){
        return userService.findUserById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteUserById(@PathVariable("id") Long id){
        return userService.deleteUserById(id);
    }

}
