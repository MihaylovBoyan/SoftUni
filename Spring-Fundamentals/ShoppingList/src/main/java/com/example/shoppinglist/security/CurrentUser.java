package com.example.shoppinglist.security;

import org.springframework.stereotype.Component;

@Component
public class CurrentUser {

    private Long id;
    private String username;

    public Long getId() {
        return id;
    }

    public CurrentUser setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public CurrentUser setUsername(String username) {
        this.username = username;
        return this;
    }

    public boolean isLoggedIn(){
        return id != null;
    }
}
