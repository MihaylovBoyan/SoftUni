package com.example.mobi.service;

import com.example.mobi.model.service.UserLoginServiceModel;

public interface UserService {

    boolean login(UserLoginServiceModel userLoginServiceModel);

    void logout();

    void initializeUsersAndRoles();
}
