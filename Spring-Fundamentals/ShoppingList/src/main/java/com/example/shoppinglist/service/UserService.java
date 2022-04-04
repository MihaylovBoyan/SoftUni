package com.example.shoppinglist.service;

import com.example.shoppinglist.model.service.RegisterUserServiceModel;

public interface UserService {

    boolean register(RegisterUserServiceModel map);

    RegisterUserServiceModel findByUsernameAndPassword(String username, String password);
}
