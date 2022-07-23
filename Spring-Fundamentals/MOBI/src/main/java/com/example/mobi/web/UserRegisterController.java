package com.example.mobi.web;

import com.example.mobi.model.binding.UserRegisterBindingModel;
import com.example.mobi.model.service.UserRegisterServiceModel;
import com.example.mobi.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class UserRegisterController {

    private final UserService userService;
    private final ModelMapper modelMapper;

    public UserRegisterController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @ModelAttribute(name = "userModel")
    public UserRegisterBindingModel userModel(){
        return new UserRegisterBindingModel();
    }

    @GetMapping("/users/register")
    public String register(Model model) {



        return "auth-register";
    }

    @PostMapping("/users/register")
    public String registerConfirm(@Valid UserRegisterBindingModel userModel, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userModel", userModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userModel", bindingResult);

            return "redirect:/users/register";
        }

        if (!userService.isUsernameFree(userModel.getUsername())) {
            redirectAttributes.addFlashAttribute("userModel", userModel);
            redirectAttributes.addFlashAttribute("usernameOccupied", true);
            return "redirect:/users/register";
        } else {
            userService.registerAndLoginUser(modelMapper.map(userModel, UserRegisterServiceModel.class));
        }


        return "redirect:/";
    }


}
