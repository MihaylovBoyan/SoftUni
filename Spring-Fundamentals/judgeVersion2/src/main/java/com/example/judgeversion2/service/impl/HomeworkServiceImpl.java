package com.example.judgeversion2.service.impl;

import com.example.judgeversion2.model.entity.Homework;
import com.example.judgeversion2.model.service.HomeworkServiceModel;
import com.example.judgeversion2.repository.HomeworkRepository;
import com.example.judgeversion2.security.CurrentUser;
import com.example.judgeversion2.service.ExerciseService;
import com.example.judgeversion2.service.HomeworkService;
import com.example.judgeversion2.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class HomeworkServiceImpl implements HomeworkService {


    private final HomeworkRepository homeworkRepository;
    private final ExerciseService exerciseService;
    private final CurrentUser currentUser;
    private final UserService userService;
    private final ModelMapper modelMapper;

    public HomeworkServiceImpl(HomeworkRepository homeworkRepository, ExerciseService exerciseService, CurrentUser currentUser, UserService userService, ModelMapper modelMapper) {
        this.homeworkRepository = homeworkRepository;
        this.exerciseService = exerciseService;
        this.currentUser = currentUser;
        this.userService = userService;
        this.modelMapper = modelMapper;
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

    @Override
    public HomeworkServiceModel findHomeworkWithFewestComments() {

        return homeworkRepository.findTop1ByOrderByComments().map(homework -> modelMapper.map(homework, HomeworkServiceModel.class)).orElse(null);

    }

    @Override
    public Homework findById(Long homeworkId) {

        return homeworkRepository.findById(homeworkId).orElse(null);
    }
}
