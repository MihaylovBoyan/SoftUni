package com.example.path.repository;

import com.example.path.model.entity.Role;
import com.example.path.model.entity.enums.RoleNameEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {


    Optional<Role> findByRole(RoleNameEnum role);

}
