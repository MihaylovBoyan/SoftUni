package com.example.path.service.impl;

import com.example.path.model.entity.Role;
import com.example.path.model.entity.User;
import com.example.path.model.entity.enums.RoleNameEnum;
import com.example.path.model.entity.enums.levelEnum;
import com.example.path.model.service.UserRegisterServiceModel;
import com.example.path.model.service.UserServiceModel;
import com.example.path.repository.RoleRepository;
import com.example.path.repository.UserRepository;
import com.example.path.security.CurrentUser;
import com.example.path.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final RoleRepository roleRepository;
    private final CurrentUser currentUser;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, RoleRepository roleRepository, CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;

        this.roleRepository = roleRepository;
        this.currentUser = currentUser;
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
    public UserServiceModel findUserByUsernameAndPassword(String username, String password) {

        return userRepository.findByUsernameAndPassword(username, password)
                .map(u -> modelMapper.map(u, UserServiceModel.class)).orElse(null);

    }

    @Override
    public void loginUser(Long id, String username) {
            currentUser.setUsername(username).setId(id);
    }

    @Override
    public void logout() {
        currentUser.setId(null).setUsername(null);
    }

    @Override
    public UserServiceModel findById(Long id) {
        return userRepository.findById(id)
                .map(u -> modelMapper.map(u, UserServiceModel.class)).orElse(null);
    }

    @Override
    public boolean usernameExists(String username) {
        return userRepository.existsByUsername(username);
    }


}
