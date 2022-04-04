package com.example.shoppinglist.model.service;

public class RegisterUserServiceModel {

    private Long id;
    private String username;
    private String password;
    private String email;

    public String getUsername() {
        return username;
    }

    public RegisterUserServiceModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public RegisterUserServiceModel setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public RegisterUserServiceModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public Long getId() {
        return id;
    }

    public RegisterUserServiceModel setId(Long id) {
        this.id = id;
        return this;
    }
}
