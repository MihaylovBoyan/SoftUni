package com.example.mobi.web;

import com.example.mobi.model.binding.UserLoginBindingModel;
import com.example.mobi.model.service.UserLoginServiceModel;
import com.example.mobi.service.UserService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserLoginController {

    @GetMapping("/login")
    public String login() {

        return "auth-login";
    }


}
