package com.example.jsonexercise.service;

import com.example.jsonexercise.model.dto.UserSeedDtoXml;
import com.example.jsonexercise.model.dto.UserSoldDto;
import com.example.jsonexercise.model.dto.UserViewRootDto;
import com.example.jsonexercise.model.entity.User;

import java.io.IOException;
import java.util.List;

public interface UserService {

    void seedUsersXml() throws IOException;

    User findRandomUser();

    List<UserSoldDto> findAllUsersWithMoreThanOneSoldProducts();

    long getCount();


    void seedUsersXml(List<UserSeedDtoXml> users);

    UserViewRootDto findAllUsersWithMoreThanOneSoldProductss();
}
