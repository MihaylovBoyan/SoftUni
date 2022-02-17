package com.example.workshopp.repository;

import com.example.workshopp.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByUsernameOrEmail(String username, String email);

    User findFirstByUsername(String username);
}



