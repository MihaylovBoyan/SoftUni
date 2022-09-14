package com.example.path.web;

import com.example.path.model.binding.NewCommentBindingModel;
import com.example.path.model.entity.Comment;
import com.example.path.model.entity.Route;
import com.example.path.model.entity.User;
import com.example.path.repository.CommentRepository;
import com.example.path.repository.RouteRepository;
import com.example.path.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.text.MatchesPattern;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.List;


import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WithMockUser("bobo@example.com")
@SpringBootTest
@AutoConfigureMockMvc
class CommentRestControllerTest {

    private static final String COMMENT_1 = "hey, this  i s coollllasd";
    private static final String COMMENT_2 = "not always but yea it's not badasd";

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private RouteRepository routeRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private UserRepository userRepository;

    private User testUser;

    @BeforeEach
    void setUp() {

        testUser = new User()
                .setPassword("password")
                .setUsername("bobo")
                .setFullName("bobobo")
                .setEmail("bobo@example.com");

        testUser = userRepository.save(testUser);


    }

    @AfterEach
    void tearDown() {
        routeRepository.deleteAll();
        userRepository.deleteAll();
    }

    @Test
    void testGetComments() throws Exception {
        var route = initComments(initRoute());

        mockMvc.perform(get("/api/" + route.getId() + "/comments"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$.[0].message", is(COMMENT_1)))
                .andExpect(jsonPath("$.[1].message", is(COMMENT_2)));
    }


    @Test
    void testCreateComments() throws Exception {

        NewCommentBindingModel testComment = new NewCommentBindingModel()
                .setMessage(COMMENT_1);

        var emptyRoute = initRoute();

        mockMvc.perform(

                post("/api/" + emptyRoute.getId() + "/comments")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(testComment))
                        .accept(MediaType.APPLICATION_JSON)
                        .with(csrf()))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(header().string("Location", MatchesPattern.matchesPattern("/api/" + emptyRoute.getId() + "/comments/\\d")))
                .andExpect(jsonPath("$.message").value(is(COMMENT_1)));


    }

    private Route initRoute() {
        Route testRoute = new Route()
                .setAuthor(testUser)
                .setName("Testing route");

        return routeRepository.save(testRoute);
    }

    private Route initComments(Route route) {

        Comment comment1 = new Comment();
        comment1.setCreated(LocalDateTime.now());
        comment1.setAuthor(testUser);
        comment1.setTextContent(COMMENT_1);
        comment1.setApproved(true);
        comment1.setRoute(route);

        Comment comment2 = new Comment();
        comment2.setCreated(LocalDateTime.now());
        comment2.setAuthor(testUser);
        comment2.setTextContent(COMMENT_2);
        comment2.setApproved(true);
        comment2.setRoute(route);

        route.setComments(List.of(comment1, comment2));

        return routeRepository.save(route);


    }


}
