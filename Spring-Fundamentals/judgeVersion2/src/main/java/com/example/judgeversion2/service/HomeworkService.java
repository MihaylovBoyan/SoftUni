package com.example.judgeversion2.service;

import com.example.judgeversion2.model.entity.Homework;
import com.example.judgeversion2.model.service.HomeworkServiceModel;

import java.util.List;

public interface HomeworkService {

    void addHomework(String exercise, String gitAddress);

    HomeworkServiceModel findHomeworkWithFewestComments();

    Homework findById(Long homeworkId);
}
