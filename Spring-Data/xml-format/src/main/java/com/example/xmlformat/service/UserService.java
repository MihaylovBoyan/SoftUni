package com.example.xmlformat.service;

import com.example.xmlformat.model.dto.UserSeedDto;
import com.example.xmlformat.model.dto.UserViewRootDto;
import com.example.xmlformat.model.entity.User;

import java.util.List;

public interface UserService {
    long getUsersCount();

    void seedUsers(List<UserSeedDto> users);

    User getRandomUser();

    UserViewRootDto findUsersWithMoreThanOneProduct();
}
