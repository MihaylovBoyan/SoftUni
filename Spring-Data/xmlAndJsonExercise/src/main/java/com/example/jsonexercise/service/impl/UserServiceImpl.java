package com.example.jsonexercise.service.impl;

import com.example.jsonexercise.constants.GlobalConstants;
import com.example.jsonexercise.model.dto.*;
import com.example.jsonexercise.model.entity.User;
import com.example.jsonexercise.repository.UserRepository;
import com.example.jsonexercise.service.UserService;
import com.example.jsonexercise.util.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

import static com.example.jsonexercise.constants.GlobalConstants.RESOURCES_FILE_PATH;

@Service
public class UserServiceImpl implements UserService {

    private static final String USERS_FILE_NAME = "users.json";
    private static final String USERS_AND_SOLD_PRODUCTS = "users-and-sold-products.json";

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final Gson gson;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, ValidationUtil validationUtil, Gson gson) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.gson = gson;
    }

    @Override
    public void seedUsersXml() throws IOException {

        if (userRepository.count() > 0) {
            return;
        }

        Arrays.stream(gson.fromJson(
                Files.readString(Path.of(RESOURCES_FILE_PATH + USERS_FILE_NAME)),
                UserSeedDto[].class))
                .filter(validationUtil::isValid)
                .map(userSeedDto -> modelMapper.map(userSeedDto, User.class))
                .forEach(userRepository::save);

    }

    @Override
    public User findRandomUser() {

        long randomId = ThreadLocalRandom.current().nextLong(1, userRepository.count() + 1);
        return userRepository.findById(randomId).orElse(null);
    }

    @Override
    public List<UserSoldDto> findAllUsersWithMoreThanOneSoldProducts() {
        return userRepository.findAllUsersWithMoreThanOneSoldProductOrderByLastNameThenFirstName()
                .stream()
                .map(user -> modelMapper.map(user, UserSoldDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public long getCount() {
        return userRepository.count();
    }

    @Override
    public void seedUsersXml(List<UserSeedDtoXml> users) {

        users
                .stream()
                .filter(validationUtil::isValid)
                .map(userSeedDtoXml -> modelMapper.map(userSeedDtoXml, User.class))
                .forEach(userRepository::save);

    }

    @Override
    public UserViewRootDto findAllUsersWithMoreThanOneSoldProductss() {

        UserViewRootDto userViewRootDto = new UserViewRootDto();

        userViewRootDto.setProducts(userRepository.findAllUsersWithMoreThanOneSoldProductOrderByLastNameThenFirstName()
        .stream()
        .map(user -> modelMapper.map(user, UserWithProductsDto.class))
        .collect(Collectors.toList()));

        return userViewRootDto;
    }
}
