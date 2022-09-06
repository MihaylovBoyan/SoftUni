package com.example.path.service;

import com.example.path.model.view.CommentViewModel;

import java.util.List;

public interface CommentService {

    void addComment();

    List<CommentViewModel> getComments(Long id);
}
