package com.example.mobilele.security;

import com.example.mobilele.model.entity.UserRole;
import com.example.mobilele.model.entity.enums.Role;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;
import java.util.List;

@Component
@SessionScope
public class CurrentUser {

    private static final String ANONYMOUS = "anonymous";


    private String name = ANONYMOUS;
    private boolean isAnonymous = true;
    private List<Role> userRoles = new ArrayList<>();

    public String getName() {
        return name;
    }

    public CurrentUser setName(String name) {
        this.name = name;
        return this;
    }

    public CurrentUser setUserRoles(List<Role> newUserRoles) {

        userRoles.clear();
        userRoles.addAll(newUserRoles);
        return this;

    }

    public boolean isLoggedIn() {
        return !isAnonymous();
    }

    public boolean isAnonymous() {
        return isAnonymous;
    }

    public boolean isAdmin() {
        return userRoles.contains(Role.ADMIN);
    }

    public CurrentUser setAnonymous(boolean anonymous) {
        if (anonymous) {
            this.name = ANONYMOUS;
            this.userRoles.clear();
        }
        isAnonymous = anonymous;
        return this;
    }
}
