package com.example.judgeversion2.service;

import com.example.judgeversion2.model.entity.Exercise;
import com.example.judgeversion2.model.service.ExerciseServiceModel;

import java.util.List;

public interface ExerciseService {
    void addEx(ExerciseServiceModel exerciseServiceModel);

    List<String> findAllExercises();

    boolean checkIfLate(String exercise);

    Exercise findByName(String exercise);
}
