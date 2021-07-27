package com.example.demo.controllers;

import com.example.demo.models.File;
import com.example.demo.models.User;
import com.example.demo.repositories.FileRepository;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FileController {
    @Autowired
    FileRepository fileRepository;

    @GetMapping(value = "/files")
    public ResponseEntity<List<User>> getAllFiles() {
        return new ResponseEntity(
                fileRepository.findAll(),
                HttpStatus.OK
        );
    }

    @GetMapping(value = "/files/{id}")
    public ResponseEntity getFile(@PathVariable Long id) {
        return new ResponseEntity(fileRepository.findById(id), HttpStatus.OK);
    }


    @PostMapping(value = "/files")
    public ResponseEntity createFile(@RequestBody File newFile) {
        fileRepository.save(newFile);
        return new ResponseEntity<>(newFile, HttpStatus.CREATED);
    }
}
