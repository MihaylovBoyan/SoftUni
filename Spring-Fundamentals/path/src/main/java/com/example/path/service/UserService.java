package com.example.path.service;

import com.example.path.model.service.UserRegisterServiceModel;
import com.example.path.model.service.UserServiceModel;

public interface UserService {
    void registerUser(UserRegisterServiceModel userRegisterServiceModel);

    UserServiceModel findUserByUsernameAndPassword(String username, String password);

    void loginUser(Long id, String username);

    void logout();

}
