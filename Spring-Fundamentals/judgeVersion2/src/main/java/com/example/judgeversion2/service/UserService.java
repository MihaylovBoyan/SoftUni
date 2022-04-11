package com.example.judgeversion2.service;

import com.example.judgeversion2.model.entity.User;
import com.example.judgeversion2.model.entity.enums.RoleNameEnum;
import com.example.judgeversion2.model.service.UserServiceModel;
import com.example.judgeversion2.model.view.UserProfileViewModel;

import java.util.List;
import java.util.Map;

public interface UserService {
    void registerUser(UserServiceModel userServiceModel);

    UserServiceModel findByUsernameAndPassword(String username, String password);

    void login(UserServiceModel user);

    void logout();

    List<String> findAllUsernames();

    void chanceRole(String username, RoleNameEnum roleNameEnum);

    User findByUsername(String username);

    UserProfileViewModel findProfileById(Long id);

    User findById(Long id);

    List<String> findBestStudents();

    Long userCount();

}
