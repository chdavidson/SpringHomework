package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="name")
    private String name;

    @OneToMany(mappedBy = "user")
    @JsonIgnoreProperties({"user"})
    private List<Folder> folders;

    public User(String name) {
        this.name = name;
        this.folders = new ArrayList<>();
    }

    public User() {
        this.folders = new ArrayList<>();
    }

    public void addFolder(Folder folder){
        this.folders.add(folder);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Folder> getFolders() {
        return folders;
    }

    public void setFolders(List<Folder> folders) {
        this.folders = folders;
    }
}
