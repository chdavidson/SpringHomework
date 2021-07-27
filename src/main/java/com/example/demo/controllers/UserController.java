package com.example.demo.controllers;

import com.example.demo.models.User;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;

    @GetMapping(value="/users")
    public ResponseEntity<List<User>> getAllUsers(){
        return new ResponseEntity(
                                userRepository.findAll(),
                                HttpStatus.OK
        );
    }

    @GetMapping(value="/users/{id}")
    public ResponseEntity getUser(@PathVariable Long id){
        return new ResponseEntity(userRepository.findById(id), HttpStatus.OK);
    }


    @PostMapping(value="/users")
    public ResponseEntity createUser(@RequestBody User newUser){
        userRepository.save(newUser);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }
}
