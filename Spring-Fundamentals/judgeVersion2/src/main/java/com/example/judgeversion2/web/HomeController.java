package com.example.judgeversion2.web;

import com.example.judgeversion2.security.CurrentUser;
import com.example.judgeversion2.service.CommentService;
import com.example.judgeversion2.service.ExerciseService;
import com.example.judgeversion2.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final CurrentUser currentUser;
    private final ExerciseService exerciseService;
    private final UserService userService;
    private final CommentService commentService;

    public HomeController(CurrentUser currentUser, ExerciseService exerciseService, UserService userService, CommentService commentService) {
        this.currentUser = currentUser;
        this.exerciseService = exerciseService;
        this.userService = userService;
        this.commentService = commentService;
    }

    @GetMapping("/")
    public String index(Model model) {

        if (currentUser.isAnonymous()) {
            return "index";
        }

        model.addAttribute("exercises", exerciseService.findAllExercises());
        model.addAttribute("students", commentService.findBestStudents());
        model.addAttribute("avg", commentService.findAvgScore());
        model.addAttribute("userCount", userService.userCount());
        model.addAttribute("scoreMap", commentService.findScoreMap());


        return "home";

    }


}
