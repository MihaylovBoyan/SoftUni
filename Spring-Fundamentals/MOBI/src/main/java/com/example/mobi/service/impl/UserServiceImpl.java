package com.example.mobi.service.impl;

import com.example.mobi.model.entity.UserEntity;
import com.example.mobi.model.entity.UserRoleEntity;
import com.example.mobi.model.entity.enums.UserRoleEnum;
import com.example.mobi.model.service.UserLoginServiceModel;
import com.example.mobi.model.service.UserRegisterServiceModel;
import com.example.mobi.repository.UserRepository;
import com.example.mobi.repository.UserRoleRepository;
import com.example.mobi.service.UserService;
import com.example.mobi.user.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private final CurrentUser currentUser;
    private final UserRoleRepository userRoleRepository;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder, CurrentUser currentUser, UserRoleRepository userRoleRepository) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
        this.currentUser = currentUser;
        this.userRoleRepository = userRoleRepository;
    }

    @Override
    public boolean login(UserLoginServiceModel userLoginServiceModel) {

        Optional<UserEntity> userEntityOpt = userRepository.findByUsername(userLoginServiceModel.getUsername());

        if (userEntityOpt.isEmpty()) {
            logout();
            return false;
        } else {
            boolean success = passwordEncoder.matches(userLoginServiceModel.getRawPassword(), userEntityOpt.get().getPassword());

            if (success) {
                UserEntity loggedIn = userEntityOpt.get();
                login(loggedIn);
                loggedIn.getRoles().forEach(r -> currentUser.addRole(r.getRole()));
            }
            return success;
        }
    }

    @Override
    public void logout() {
        currentUser.logout();
    }

    @Override
    public void initializeUsersAndRoles() {
        initializeRoles();
        initializeUsers();
    }

    @Override
    public void registerAndLoginUser(UserRegisterServiceModel userRegisterServiceModel) {

        UserRoleEntity userRole = userRoleRepository.findByRole(UserRoleEnum.USER);
        UserEntity newUser = new UserEntity();

        newUser
                .setUsername(userRegisterServiceModel.getUsername())
                .setFirstName(userRegisterServiceModel.getFirstName())
                .setLastName(userRegisterServiceModel.getLastName())
                .setActive(true)
                .setPassword(passwordEncoder.encode(userRegisterServiceModel.getPassword()))
                .setRoles(Set.of(userRole));

        userRepository.save(newUser);
        login(newUser);
    }

    public boolean isUsernameFree(String username){
        return userRepository.findByUsernameIgnoreCase(username).isEmpty();
    }

    private void login(UserEntity user) {

        currentUser
                .setLoggedIn(true)
                .setUsername(user.getUsername())
                .setFirstName(user.getFirstName())
                .setLastName(user.getLastName());
    }

    private void initializeUsers() {

        UserRoleEntity adminRole = userRoleRepository.findByRole(UserRoleEnum.ADMIN);
        UserRoleEntity userRole = userRoleRepository.findByRole(UserRoleEnum.USER);

        if (userRepository.count() == 0) {
            UserEntity admin = new UserEntity();
            admin
                    .setActive(true)
                    .setUsername("admin")
                    .setFirstName("Admin")
                    .setLastName("admonov")
                    .setPassword(passwordEncoder.encode("test"));

            admin.setRoles(Set.of(adminRole, userRole));
            userRepository.save(admin);


            UserEntity pesho = new UserEntity();
            pesho
                    .setActive(true)
                    .setUsername("pesho")
                    .setFirstName("Pesho")
                    .setLastName("Petrov")
                    .setPassword(passwordEncoder.encode("test"));

            pesho.setRoles(Set.of(userRole));
            userRepository.save(pesho);

        }

    }

    private void initializeRoles() {

        if (userRoleRepository.count() == 0) {
            UserRoleEntity adminRole = new UserRoleEntity();
            adminRole.setRole(UserRoleEnum.ADMIN);

            UserRoleEntity userRole = new UserRoleEntity();
            userRole.setRole(UserRoleEnum.USER);

            userRoleRepository.saveAll(List.of(adminRole, userRole));
        }

    }
}
