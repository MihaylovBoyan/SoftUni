package com.example.mobilele.service;

public interface UserService {

    boolean authenticate(String username, String password);

    void loginUser(String username);

    void logout();
}
