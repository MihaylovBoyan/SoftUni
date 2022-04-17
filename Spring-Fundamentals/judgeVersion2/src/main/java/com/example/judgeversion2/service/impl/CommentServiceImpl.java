package com.example.judgeversion2.service.impl;

import com.example.judgeversion2.model.binding.CommentAddBindingModel;
import com.example.judgeversion2.model.entity.Comment;
import com.example.judgeversion2.repository.CommentRepository;
import com.example.judgeversion2.security.CurrentUser;
import com.example.judgeversion2.service.CommentService;
import com.example.judgeversion2.service.HomeworkService;
import com.example.judgeversion2.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CommentServiceImpl implements CommentService {

    private final ModelMapper modelMapper;
    private final CommentRepository commentRepository;
    private final UserService userService;
    private final CurrentUser currentUser;
    private final HomeworkService homeworkService;

    public CommentServiceImpl(ModelMapper modelMapper, CommentRepository commentRepository, UserService userService, CurrentUser currentUser, HomeworkService homeworkService) {
        this.modelMapper = modelMapper;
        this.commentRepository = commentRepository;
        this.userService = userService;
        this.currentUser = currentUser;
        this.homeworkService = homeworkService;
    }

    @Override
    public void saveComment(CommentAddBindingModel commentAddBindingModel) {

        System.out.println(commentAddBindingModel.getTextContent());

        Comment comment = modelMapper.map(commentAddBindingModel, Comment.class);
        comment.setTextContext(commentAddBindingModel.getTextContent());
        comment.setHomework(homeworkService.findById(commentAddBindingModel.getHomeworkId()));
        comment.setAuthor(userService.findById(currentUser.getId()));


        commentRepository.save(comment);
    }

    @Override
    public List<String> findBestStudents() {



   commentRepository.findAllBy().forEach(System.out::println);

        return commentRepository.findAllBy();
    }

    @Override
    public Double findAvgScore() {
        return commentRepository.findAvgScore();
    }

    @Override
    public Map<Integer, Integer> findScoreMap() {

        Map<Integer, Integer> scoreMap = initScoreMap();


        commentRepository.findAll()
        .forEach(comment -> {

            Integer score = comment.getScore();
            scoreMap.put(score, scoreMap.get(score) + 1);

        });

        return scoreMap;
    }

    private Map<Integer, Integer> initScoreMap() {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 2; i <= 6; i++) {
            map.put(i, 0);
        }

        return map;
    }
}
