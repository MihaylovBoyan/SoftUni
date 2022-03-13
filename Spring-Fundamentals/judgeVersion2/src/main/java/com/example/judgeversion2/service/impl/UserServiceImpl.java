package com.example.judgeversion2.service.impl;

import com.example.judgeversion2.model.entity.User;
import com.example.judgeversion2.model.entity.enums.RoleNameEnum;
import com.example.judgeversion2.model.service.UserServiceModel;
import com.example.judgeversion2.repository.UserRepository;
import com.example.judgeversion2.service.RoleService;
import com.example.judgeversion2.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final RoleService roleService;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, RoleService roleService) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.roleService = roleService;
    }

    @Override
    public void registerUser(UserServiceModel userServiceModel) {
        User user = modelMapper.map(userServiceModel, User.class);
        user.setRole(roleService.findRole(RoleNameEnum.USER));
        userRepository.save(user);


    }

    @Override
    public UserServiceModel findByUsernameAndPassword(String username, String password) {
        //User user = userRepository.findByUsernameAndPassword(username, password).orElse(null);
        return userRepository.findByUsernameAndPassword(username, password)
                .map(user -> modelMapper.map(user , UserServiceModel.class))
                .orElse(null);
    }
}
