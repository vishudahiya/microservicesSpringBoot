package com.example.UserService.service;

import com.example.UserService.modal.User;
import com.example.UserService.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;


    public List<User> getAllUser() {
        return userRepo.findAll();
    }

    public User getUser(UUID id) {
        return userRepo.findById(id).get();
    }

    public User saveUser(User user) {
        return userRepo.save(user);
    }

    public void deleteUser(UUID id) {
        userRepo.deleteById(id);
    }

    public User updateUser(User user) {
        return userRepo.save(user);
    }
}
