package com.example.quizzone.service;

import java.util.List;

import com.example.quizzone.entity.User;

public interface UserService {
    User getUserById(Long userId);
    List<User> getAllUsers();
    User createUser(User user);
    User updateUser(User user);
    void deleteUser(Long userId);
  
}


