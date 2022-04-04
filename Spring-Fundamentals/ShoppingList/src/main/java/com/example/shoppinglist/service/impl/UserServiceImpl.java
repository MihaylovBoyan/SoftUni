package com.example.shoppinglist.service.impl;

import com.example.shoppinglist.model.entity.User;
import com.example.shoppinglist.model.service.RegisterUserServiceModel;
import com.example.shoppinglist.repository.UserRepository;
import com.example.shoppinglist.service.UserService;
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
    public boolean register(RegisterUserServiceModel userModel) {

        try {
            userRepository.save(modelMapper.map(userModel, User.class));
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public RegisterUserServiceModel findByUsernameAndPassword(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password)
                .map(user -> modelMapper.map(user, RegisterUserServiceModel.class))
                .orElse(null);
    }
}
