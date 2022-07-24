package com.example.path.model.service;

import com.example.path.model.entity.Role;
import com.example.path.model.entity.enums.levelEnum;

import java.util.Set;

public class UserRegisterServiceModel {

    private Long id;
    private String username;
    private String password;
    private String fullName;
    private String email;
    private Integer age;
    private levelEnum level;
    private Set<Role> roles;

    public Long getId() {
        return id;
    }

    public UserRegisterServiceModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserRegisterServiceModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserRegisterServiceModel setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public UserRegisterServiceModel setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserRegisterServiceModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public UserRegisterServiceModel setAge(Integer age) {
        this.age = age;
        return this;
    }

    public levelEnum getLevel() {
        return level;
    }

    public UserRegisterServiceModel setLevel(levelEnum level) {
        this.level = level;
        return this;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public UserRegisterServiceModel setRoles(Set<Role> roles) {
        this.roles = roles;
        return this;
    }
}
