package com.example.path.model.service;

import com.example.path.model.binding.UserLoginBindingModel;

public class UserServiceModel {

    private Long id;
    private String username;
    private String password;

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
}
