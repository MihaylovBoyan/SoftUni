package com.example.andreys.repository;

import com.example.andreys.model.entity.User;
import com.example.andreys.model.service.UserServiceModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByUsernameOrEmail(String username, String email);

    Optional<User> findByUsername(String username);
}
