package com.example.andreys.service;

import com.example.andreys.model.service.UserServiceModel;

public interface UserService {

    void register(UserServiceModel userServiceModel);

    UserServiceModel findByUsername(String username);
}
