package com.example.mobi.model.binding;

import javax.validation.constraints.Size;

public class UserLoginBindingModel {

    @Size(min = 3, max = 20)
    private String username;

    @Size(min = 3, max = 20)
    private String password;


    public String getUsername() {
        return username;
    }

    public UserLoginBindingModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserLoginBindingModel setPassword(String password) {
        this.password = password;
        return this;
    }
}
