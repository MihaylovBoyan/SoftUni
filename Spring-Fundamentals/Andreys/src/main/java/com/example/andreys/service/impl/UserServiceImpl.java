package com.example.andreys.service.impl;

import com.example.andreys.model.entity.User;
import com.example.andreys.model.service.UserServiceModel;
import com.example.andreys.repository.UserRepository;
import com.example.andreys.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void register(UserServiceModel userServiceModel) {
        if (userRepository.existsByUsernameOrEmail(userServiceModel.getUsername(), userServiceModel.getEmail())) {


        }

        userRepository.save(modelMapper.map(userServiceModel, User.class));

    }

    @Override
    public UserServiceModel findByUsername(String username) {

        return userRepository.findByUsername(username)
                .map(user -> modelMapper.map(user, UserServiceModel.class))
                .orElse(null);
    }
}
