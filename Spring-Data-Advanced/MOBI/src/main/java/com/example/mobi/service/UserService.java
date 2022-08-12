package com.example.mobi.service;

import com.example.mobi.model.service.UserLoginServiceModel;
import com.example.mobi.model.service.UserRegisterServiceModel;

public interface UserService {

    void initializeUsersAndRoles();

    void registerAndLoginUser(UserRegisterServiceModel userRegisterServiceModel);

    boolean isUsernameFree(String username);
}
