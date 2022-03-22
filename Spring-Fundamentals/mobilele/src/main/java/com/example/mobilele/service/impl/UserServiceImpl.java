package com.example.mobilele.service.impl;

import com.example.mobilele.model.entity.User;
import com.example.mobilele.model.entity.UserRole;
import com.example.mobilele.model.entity.enums.Role;
import com.example.mobilele.repository.UserRepository;
import com.example.mobilele.security.CurrentUser;
import com.example.mobilele.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final CurrentUser currentUser;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.currentUser = currentUser;
    }

    @Override
    public boolean authenticate(String username, String password) {

        Optional<User> userOPt = userRepository.findByUsername(username);

        if (userOPt.isEmpty()) {
            return false;
        } else {
            return passwordEncoder.matches(password, userOPt.get().getPassword());
        }


    }

    @Override
    public void loginUser(String username) {

        User user = userRepository.findByUsername(username).orElseThrow();

        List<Role> userRoles = user.getUserRoles()
                .stream()
                .map(UserRole::getName)
                .collect(Collectors.toList());

        currentUser.setAnonymous(false)
                .setName(user.getUsername())
                .setUserRoles(userRoles);

    }

    @Override
    public void logout() {
        currentUser.setAnonymous(true);
    }
}
