package com.example.judgeversion2.model.binding;

import org.hibernate.validator.constraints.Length;

public class UserLoginBindingModel {

    private String username;
    private String password;

    @Length(min = 2, message = "username length must be at least 2 characters.")
    public String getUsername() {
        return username;
    }

    public UserLoginBindingModel setUsername(String username) {
        this.username = username;
        return this;
    }

    @Length(min = 3, message = "password length must be at least 3 characters.")
    public String getPassword() {
        return password;
    }

    public UserLoginBindingModel setPassword(String password) {
        this.password = password;
        return this;
    }
}
