package com.example.workshopp.controller;

import com.example.workshopp.model.dto.UserLoginDto;
import com.example.workshopp.model.dto.UserRegisterDto;
import com.example.workshopp.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/register")
    public String register() {
        return "user/register";
    }

    @PostMapping("/users/register")
    public String register(UserRegisterDto user, Model model) {

        if (userService.register(user)) {
            return "redirect:/user/login";
        }

        model.addAttribute("error", "There is an error");
        return "user/register";
    }


    @GetMapping("/users/login")
    public String login() {
        return "user/login";
    }

    @PostMapping("/users/login")
    public String login(UserLoginDto userRequest, Model model, HttpServletRequest request) {

        Long userId = userService.validateUserLoginDetails(userRequest);

        if (userId == null) {
            model.addAttribute("error", "There is an error");
            return "user/login";
        }


        request.getSession().setAttribute("userId", userId);

        return "redirect:/";
    }

//    @PostMapping
//    public String logout(HttpServletRequest request){
//        String id = request.getSession().Id();
//    }


}
