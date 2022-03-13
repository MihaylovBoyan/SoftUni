package com.example.judgeversion2.repository;

import com.example.judgeversion2.model.entity.Role;
import com.example.judgeversion2.model.entity.enums.RoleNameEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByName(RoleNameEnum roleNameEnum);



}
