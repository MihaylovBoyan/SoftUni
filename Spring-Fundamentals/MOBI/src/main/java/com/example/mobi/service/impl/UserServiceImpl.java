package com.example.mobi.service.impl;

import com.example.mobi.model.service.UserLoginServiceModel;
import com.example.mobi.repository.UserRepository;
import com.example.mobi.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean login(UserLoginServiceModel userLoginServiceModel) {




        return false;
    }
}
