package com.example.path.service;

import com.example.path.model.service.CommentServiceModel;
import com.example.path.model.view.CommentViewModel;

import java.util.List;

public interface CommentService {

    CommentViewModel createComment(CommentServiceModel commentServiceModel);

    List<CommentViewModel> getComments(Long id);


}
