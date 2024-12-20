package com.example.UserService.controller;

import com.example.UserService.modal.User;
import com.example.UserService.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public List<User> getALlUser(){
        return userService.getAllUser();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable UUID id){
        return userService.getUser(id);
    }

    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody User user){
        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public String updateUser(@PathVariable UUID id, @RequestBody User user){
        userService.updateUser(user);
        return "Updated";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable UUID id){
        userService.deleteUser(id);
        return "Deleted";
    }

//    @GetMapping("/allUsers")
//    public String hello(){
//        return "Hello";
//    }
}
