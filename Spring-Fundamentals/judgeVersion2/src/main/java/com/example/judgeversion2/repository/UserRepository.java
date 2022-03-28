package com.example.judgeversion2.repository;

import com.example.judgeversion2.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsernameAndPassword(String username, String password);

    @Query("select u.username from User u order by u.username")
    List<String> findAllUsernames();

    Optional<User> findByUsername(String username);
}
