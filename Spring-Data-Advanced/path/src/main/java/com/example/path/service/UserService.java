package com.example.path.service;

import com.example.path.model.entity.User;
import com.example.path.model.service.UserRegisterServiceModel;
import com.example.path.model.service.UserServiceModel;

public interface UserService {
    void registerUser(UserRegisterServiceModel userRegisterServiceModel);

    UserServiceModel findById(Long id);

}
