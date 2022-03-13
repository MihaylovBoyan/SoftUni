package com.example.judgeversion2.service;

import com.example.judgeversion2.model.entity.Role;
import com.example.judgeversion2.model.entity.enums.RoleNameEnum;

public interface RoleService {

    void initRoles();

    Role findRole(RoleNameEnum roleNameEnum);

}

