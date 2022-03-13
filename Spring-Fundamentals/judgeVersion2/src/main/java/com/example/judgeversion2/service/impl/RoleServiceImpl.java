package com.example.judgeversion2.service.impl;

import com.example.judgeversion2.model.entity.Role;
import com.example.judgeversion2.model.entity.enums.RoleNameEnum;
import com.example.judgeversion2.repository.RoleRepository;
import com.example.judgeversion2.service.RoleService;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void initRoles() {

        if(roleRepository.count() == 0){

            Role admin = new Role(RoleNameEnum.ADMIN);
            Role user = new Role(RoleNameEnum.USER);

            roleRepository.save(admin);
            roleRepository.save(user);

        }

    }

    @Override
    public Role findRole(RoleNameEnum roleNameEnum) {
        return roleRepository.findByName(roleNameEnum).orElse(null);

    }

}
