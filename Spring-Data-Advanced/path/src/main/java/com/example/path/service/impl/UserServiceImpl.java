package com.example.path.service.impl;

import com.example.path.model.entity.Role;
import com.example.path.model.entity.User;
import com.example.path.model.entity.enums.RoleNameEnum;
import com.example.path.model.entity.enums.levelEnum;
import com.example.path.model.service.UserRegisterServiceModel;
import com.example.path.model.service.UserServiceModel;
import com.example.path.repository.RoleRepository;
import com.example.path.repository.UserRepository;
import com.example.path.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final RoleRepository roleRepository;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.roleRepository = roleRepository;
    }

    @Override
    public void registerUser(UserRegisterServiceModel userRegisterServiceModel) {

        Role userRole = roleRepository.findByRole(RoleNameEnum.USER).orElse(null);
        User user = modelMapper.map(userRegisterServiceModel, User.class);
        user.setLevel(levelEnum.BEGINNER)
                .setRoles(Set.of(userRole));

        userRepository.save(user);

    }

    @Override
    public UserServiceModel findById(Long id) {
        return userRepository.findById(id)
                .map(u -> modelMapper.map(u, UserServiceModel.class)).orElse(null);
    }

}
