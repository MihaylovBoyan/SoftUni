package com.example.workshopp.service;

import com.example.workshopp.model.dto.UserLoginDto;
import com.example.workshopp.model.dto.UserRegisterDto;
import com.example.workshopp.model.entity.User;
import com.example.workshopp.repository.UserRepository;
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
    public boolean register(UserRegisterDto userRequest) {

        if (userRepository.existsByUsernameOrEmail(
                userRequest.getUsername(),
                userRequest.getEmail())) {
            return false;
        }

        if (!userRequest.getPassword().equals(userRequest.getConfirmPassword())) {
            return false;
        }


        User user = modelMapper.map(userRequest, User.class);
        userRepository.save(user);

        return true;
    }

    @Override
    public Long validateUserLoginDetails(UserLoginDto userRequest) {

        User user = userRepository.findFirstByUsername(userRequest.getUsername());

        if (user == null) {
            return null;
        }

        if(!user.getPassword().equals(userRequest.getPassword())){
            return null;
        }

        return user.getId();
    }
}
