package com.example.workshopp.service;

import com.example.workshopp.model.dto.UserLoginDto;
import com.example.workshopp.model.dto.UserRegisterDto;

public interface UserService {

    boolean register(UserRegisterDto user);

    Long validateUserLoginDetails(UserLoginDto userLoginDto);

}
