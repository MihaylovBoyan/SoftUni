package com.example.judgeversion2.web;


import com.example.judgeversion2.model.entity.enums.RoleNameEnum;
import com.example.judgeversion2.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/roles")
public class RoleController {

    private final UserService userService;

    public RoleController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/add")
    public String add(Model model) {

        model.addAttribute("names", userService.findAllUsernames());

        return "role-add";
    }


    @PostMapping("/add")
    public String addConfirm(@RequestParam String username, @RequestParam String role) {


        userService.chanceRole(username, RoleNameEnum.valueOf(role.toUpperCase()));

        return "redirect:/";
    }


}
