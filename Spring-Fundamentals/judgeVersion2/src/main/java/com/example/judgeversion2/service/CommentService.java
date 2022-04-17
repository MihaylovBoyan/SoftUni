package com.example.judgeversion2.service;

import com.example.judgeversion2.model.binding.CommentAddBindingModel;

import java.util.List;
import java.util.Map;

public interface CommentService {


    void saveComment(CommentAddBindingModel commentAddBindingModel);

    List<String> findBestStudents();

    Double findAvgScore();

    Map<Integer, Integer> findScoreMap();
}
