package com.example.path.sevice.impl;

import com.example.path.model.entity.Role;
import com.example.path.model.entity.User;
import com.example.path.model.entity.enums.RoleNameEnum;
import com.example.path.repository.UserRepository;
import com.example.path.service.impl.PathfinderUserDetailsService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@ExtendWith(MockitoExtension.class)
class PathfinderUserDetailsServiceTest {

    private User testUser;
    private Role adminRole, userRole;

    private PathfinderUserDetailsService serviceToTest;

    @Mock
    private UserRepository mockUserRepository;

    @BeforeEach
    void init() {
        //ARRANGE
        serviceToTest = new PathfinderUserDetailsService(mockUserRepository);

        adminRole = new Role().setRole(RoleNameEnum.ADMIN);
        userRole = new Role().setRole(RoleNameEnum.USER);

        testUser = new User()
                .setUsername("lucho")
                .setEmail("lucho@abv.bg")
                .setRoles(Set.of(adminRole, userRole))
                .setPassword("topsecret");
    }

    @Test
    void testUserNotFound() {
        Assertions.assertThrows(
                UsernameNotFoundException.class,
                () -> serviceToTest.loadUserByUsername("invalid_user_email@not-exist.com")
        );

    }

    @Test
    void testUserFound() {
        //ARRANGE
        Mockito.when(mockUserRepository.findByEmail(testUser.getEmail())).thenReturn(Optional.of(testUser));

        // ACT
        var actual = serviceToTest.loadUserByUsername(testUser.getEmail());

        //ASSERT
        String expectedRoles = "ROLE_ADMIN, ROLE_USER";
        String actualRoles = actual.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.joining(", "));

        Assertions.assertEquals(actual.getUsername(), testUser.getEmail());
        Assertions.assertEquals(expectedRoles, actualRoles);

    }

}
