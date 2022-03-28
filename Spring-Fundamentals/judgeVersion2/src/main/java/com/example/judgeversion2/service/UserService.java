package com.example.judgeversion2.service;

import com.example.judgeversion2.model.entity.User;
import com.example.judgeversion2.model.entity.enums.RoleNameEnum;
import com.example.judgeversion2.model.service.UserServiceModel;

import java.util.List;

public interface UserService {
    void registerUser(UserServiceModel userServiceModel);

    UserServiceModel findByUsernameAndPassword(String username, String password);

    void login(UserServiceModel user);

    void logout();

    List<String> findAllUsernames();

    void chanceRole(String username, RoleNameEnum roleNameEnum);

    User findByUsername(String username);
}
