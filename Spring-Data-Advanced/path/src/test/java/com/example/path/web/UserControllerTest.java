package com.example.path.web;

import com.example.path.model.entity.Role;
import com.example.path.model.entity.User;
import com.example.path.model.entity.enums.RoleNameEnum;
import com.example.path.repository.RoleRepository;
import com.example.path.repository.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.net.URI;
import java.util.Optional;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Test
    void testOpenRegisterForm() throws Exception {

        mockMvc
                .perform
                (get("/users/register"))
                .andExpect(status().isOk())
                .andExpect(view().name("register"));
    }

    private static final String TEST_USER_EMAIl = "pesho@abv.bg";
    private static final int TEST_USER_AGE = 12;

    @BeforeEach
    private void initRoles(){

       roleRepository.save(new Role().setRole(RoleNameEnum.USER));

    }

    @AfterEach
    void tearDown(){
        userRepository.deleteAll();
    }

    @Test
    void testRegisterUser() throws Exception {

        mockMvc.perform(
                post("/users/register")
                .param("username",TEST_USER_EMAIl)
                .param("fullName","pesho petrtov")
                .param("email",TEST_USER_EMAIl)
                .param("age", String.valueOf(TEST_USER_AGE))
                .param("password","12345")
                .param("confirmPassword","12345")
                .with(csrf())
                .contentType(MediaType.APPLICATION_FORM_URLENCODED))
                .andExpect(status().is3xxRedirection());

        Assertions.assertEquals(1, userRepository.count());

        Optional<User> newUser = userRepository.findByEmail(TEST_USER_EMAIl);

        Assertions.assertTrue(newUser.isPresent());

        User user = newUser.get();

        Assertions.assertEquals(TEST_USER_AGE, user.getAge());
    // todo - check the remaining properties
    }


}