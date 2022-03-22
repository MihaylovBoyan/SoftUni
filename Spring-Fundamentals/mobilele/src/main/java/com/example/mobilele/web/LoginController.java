package com.example.mobilele.web;

import com.example.mobilele.model.service.UserLoginServiceModel;
import com.example.mobilele.security.CurrentUser;
import com.example.mobilele.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller

public class LoginController {

    private final CurrentUser currentUser;
    private final ModelMapper modelMapper;
    private final UserService userService;

    public LoginController(CurrentUser currentUser, ModelMapper modelMapper, UserService userService) {
        this.currentUser = currentUser;
        this.modelMapper = modelMapper;
        this.userService = userService;
    }

    @ModelAttribute("userModel")
    public UserLoginServiceModel userModel(){

        return new UserLoginServiceModel();
    }

    @GetMapping("/users/login")
    public String login() {


        return "auth-login";
    }

    @PostMapping("/users/login")
    public String loginConfirm(@Valid @ModelAttribute UserLoginServiceModel userModel,
                               BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if(bindingResult.hasErrors()){

            redirectAttributes.addFlashAttribute("userModel", userModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userModel", bindingResult);

            return "redirect:/users/login";
        }

        if (userService.authenticate(userModel.getUsername(), userModel.getPassword())) {
            userService.loginUser(userModel.getUsername());

            return "redirect:/";
        } else {

            redirectAttributes.addFlashAttribute("userModel", userModel);
            redirectAttributes.addFlashAttribute("notFound", true);
            return "redirect:/users/login";
        }
    }


    @PostMapping("/users/logout")
    public String logout(){

        userService.logout();

        return "redirect:/";
    }


}
