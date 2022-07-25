package com.example.path.model.service;

import com.example.path.model.binding.UserLoginBindingModel;
import com.example.path.model.entity.enums.levelEnum;

public class UserServiceModel {

    private Long id;
    private String username;
    private String password;
    private String fullName;
    private Integer age;
    private levelEnum level;

    public String getUsername() {
        return username;
    }

    public UserServiceModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserServiceModel setPassword(String password) {
        this.password = password;
        return this;
    }

    public Long getId() {
        return id;
    }

    public UserServiceModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public UserServiceModel setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public UserServiceModel setAge(Integer age) {
        this.age = age;
        return this;
    }

    public levelEnum getLevel() {
        return level;
    }

    public UserServiceModel setLevel(levelEnum level) {
        this.level = level;
        return this;
    }
}
