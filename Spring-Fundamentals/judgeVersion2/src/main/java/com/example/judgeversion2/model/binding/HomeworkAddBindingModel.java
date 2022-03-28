package com.example.judgeversion2.model.binding;

import com.example.judgeversion2.model.entity.Exercise;

import javax.validation.constraints.Pattern;

public class HomeworkAddBindingModel {

    private String exercise;
    private String gitAddress;

    public String getExercise() {
        return exercise;
    }

    public HomeworkAddBindingModel setExercise(String exercise) {
        this.exercise = exercise;
        return this;
    }

    @Pattern(regexp = "https:\\/\\/github.com\\/.+")
    public String getGitAddress() {
        return gitAddress;
    }

    public HomeworkAddBindingModel setGitAddress(String gitAddress) {
        this.gitAddress = gitAddress;
        return this;
    }
}
