package com.example.xmlformat.service.impl;

import com.example.xmlformat.model.dto.UserSeedDto;
import com.example.xmlformat.model.dto.UserViewRootDto;
import com.example.xmlformat.model.dto.UserWithProductsDto;
import com.example.xmlformat.model.entity.User;
import com.example.xmlformat.repository.UserRepository;
import com.example.xmlformat.service.UserService;
import com.example.xmlformat.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public long getUsersCount() {
        return userRepository.count();
    }

    @Override
    public void seedUsers(List<UserSeedDto> users) {

        users
                .stream()
                .filter(validationUtil::isValid)
                .map(userSeedDto -> modelMapper.map(userSeedDto, User.class))
                .forEach(userRepository::save);


    }

    @Override
    public User getRandomUser() {
        long rand = ThreadLocalRandom.current().nextLong(1, userRepository.count() + 1);
        return userRepository.findById(rand).orElse(null);
    }

    @Override
    public UserViewRootDto findUsersWithMoreThanOneProduct() {

        UserViewRootDto userViewRootDto = new UserViewRootDto();

        userViewRootDto.setProducts(
                userRepository.findAllUsersWithMoreThanOneSoldProduct()
                .stream()
                .map(user -> modelMapper.map(user, UserWithProductsDto.class))
                .collect(Collectors.toList())
        );



        return userViewRootDto;
    }
}


