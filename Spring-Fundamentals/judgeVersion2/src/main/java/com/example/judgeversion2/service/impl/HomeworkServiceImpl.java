package com.example.judgeversion2.service.impl;

import com.example.judgeversion2.model.entity.Exercise;
import com.example.judgeversion2.model.entity.Homework;
import com.example.judgeversion2.model.entity.User;
import com.example.judgeversion2.repository.HomeworkRepository;
import com.example.judgeversion2.security.CurrentUser;
import com.example.judgeversion2.service.ExerciseService;
import com.example.judgeversion2.service.HomeworkService;
import com.example.judgeversion2.service.UserService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class HomeworkServiceImpl implements HomeworkService {


    private final HomeworkRepository homeworkRepository;
    private final ExerciseService exerciseService;
    private final CurrentUser currentUser;
    private final UserService userService;

    public HomeworkServiceImpl(HomeworkRepository homeworkRepository, ExerciseService exerciseService, CurrentUser currentUser, UserService userService) {
        this.homeworkRepository = homeworkRepository;
        this.exerciseService = exerciseService;
        this.currentUser = currentUser;
        this.userService = userService;
    }


    @Override
    public void addHomework(String exercise, String gitAddress) {

        Homework homework = new Homework();
        homework.setExercise(exerciseService.findByName(exercise));
        homework.setAuthor(userService.findByUsername(currentUser.getUsername()));
        homework.setGitAddress(gitAddress);
        homework.setAddedOn(LocalDateTime.now());

        homeworkRepository.save(homework);

    }
}
