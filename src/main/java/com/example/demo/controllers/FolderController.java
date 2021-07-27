package com.example.demo.controllers;

import com.example.demo.models.Folder;
import com.example.demo.models.User;
import com.example.demo.repositories.FolderRepository;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FolderController {
    @Autowired
    FolderRepository folderRepository;

    @GetMapping(value="/folders")
    public ResponseEntity<List<User>> getAllFolders(){
        return new ResponseEntity(
                folderRepository.findAll(),
                HttpStatus.OK
        );
    }

    @GetMapping(value="/folders/{id}")
    public ResponseEntity getFolder(@PathVariable Long id){
        return new ResponseEntity(folderRepository.findById(id), HttpStatus.OK);
    }


    @PostMapping(value="/folders")
    public ResponseEntity createFolder(@RequestBody Folder newFolder){
        folderRepository.save(newFolder);
        return new ResponseEntity<>(newFolder, HttpStatus.CREATED);
    }
}
