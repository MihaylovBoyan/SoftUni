package com.example.judgeversion2.service.impl;

import com.example.judgeversion2.model.entity.Homework;
import com.example.judgeversion2.model.entity.User;
import com.example.judgeversion2.model.entity.enums.RoleNameEnum;
import com.example.judgeversion2.model.service.UserServiceModel;
import com.example.judgeversion2.model.view.UserProfileViewModel;
import com.example.judgeversion2.repository.UserRepository;
import com.example.judgeversion2.security.CurrentUser;
import com.example.judgeversion2.service.ExerciseService;
import com.example.judgeversion2.service.HomeworkService;
import com.example.judgeversion2.service.RoleService;
import com.example.judgeversion2.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final RoleService roleService;
    private final CurrentUser currentUser;


    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, RoleService roleService, CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.roleService = roleService;
        this.currentUser = currentUser;
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
                .map(user -> modelMapper.map(user, UserServiceModel.class))
                .orElse(null);
    }

    @Override
    public void login(UserServiceModel user) {
        currentUser.setId(user.getId());
        currentUser.setUsername(user.getUsername());
        currentUser.setRole(user.getRole().getName());
    }

    @Override
    public void logout() {
        currentUser.setId(null).setUsername(null).setRole(null);
    }

    @Override
    public List<String> findAllUsernames() {
        return userRepository.findAllUsernames();
    }

    @Override
    public void chanceRole(String username, RoleNameEnum roleNameEnum) {

        User user = userRepository.findByUsername(username).orElse(null);

        if (user.getRole().getName() != roleNameEnum) {
            user.setRole(roleService.findRole(roleNameEnum));
        }

        userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {

        return userRepository.findByUsername(username).orElseThrow();
    }

    @Override
    public UserProfileViewModel findProfileById(Long id) {

        User user = userRepository.findById(id).orElse(null);
        UserProfileViewModel userProfileViewModel = modelMapper.map(user, UserProfileViewModel.class);
        userProfileViewModel.setHomeworkSet(user.getHomeworkSet().stream().map(homework -> homework.getExercise().getName()).collect(Collectors.toSet()));

        return userProfileViewModel;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public List<String> findBestStudents() {

      //
        return null;
    }

    @Override
    public Long userCount() {
        return userRepository.count();
    }


}
