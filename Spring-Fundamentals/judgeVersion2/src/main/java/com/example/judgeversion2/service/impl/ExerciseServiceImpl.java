package com.example.judgeversion2.service.impl;

import com.example.judgeversion2.model.entity.Exercise;
import com.example.judgeversion2.model.service.ExerciseServiceModel;
import com.example.judgeversion2.repository.ExerciseRepository;
import com.example.judgeversion2.service.ExerciseService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
 public class ExerciseServiceImpl implements ExerciseService {

    private final ExerciseRepository exerciseRepository;
    private final ModelMapper modelMapper;

    public ExerciseServiceImpl(ExerciseRepository exerciseRepository, ModelMapper modelMapper) {
        this.exerciseRepository = exerciseRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void addEx(ExerciseServiceModel exerciseServiceModel) {
        exerciseRepository.save(modelMapper.map(exerciseServiceModel, Exercise.class));
    }

    @Override
    public List<String> findAllExercises() {
        return exerciseRepository.findAllExercisesByName();
    }

    @Override
    public boolean checkIfLate(String exercise) {

        Exercise ex = exerciseRepository.findByName(exercise).orElseThrow();

        return ex.getDueDate().isBefore(LocalDateTime.now());
    }

    @Override
    public Exercise findByName(String exercise) {
        return exerciseRepository.findByName(exercise).orElseThrow();
    }
}
