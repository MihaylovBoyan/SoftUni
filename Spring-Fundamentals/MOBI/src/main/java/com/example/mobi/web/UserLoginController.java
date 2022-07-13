package com.example.mobi.web;

import com.example.mobi.model.binding.UserLoginBindingModel;
import com.example.mobi.model.service.UserLoginServiceModel;
import com.example.mobi.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserLoginController {

    private final UserService userService;
    private final ModelMapper modelMapper;

    public UserLoginController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/login")
    public String login() {

        return "auth-login";
    }

    @PostMapping("/login")
    public String loginConfirm(@Valid UserLoginBindingModel userLoginBindingModel) {

        boolean loginSuccess = userService.login(modelMapper.map(userLoginBindingModel, UserLoginServiceModel.class));

        return "redirect:/";
    }


}
