package com.example.path.service.impl;

import com.example.path.model.entity.Comment;
import com.example.path.model.entity.Route;
import com.example.path.model.view.CommentViewModel;
import com.example.path.repository.CommentRepository;
import com.example.path.repository.RouteRepository;
import com.example.path.service.CommentService;
import com.example.path.service.exceptions.ObjectNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final RouteRepository routeRepository;

    public CommentServiceImpl(CommentRepository commentRepository, RouteRepository routeRepository) {
        this.commentRepository = commentRepository;
        this.routeRepository = routeRepository;
    }

    @Override
    public void addComment() {

    }

    @Override
    public List<CommentViewModel> getComments(Long id) {

        Optional<Route> routeOpt = routeRepository.findById(id);

        if(routeOpt.isEmpty()){
            throw new ObjectNotFoundException("Root with id" + id + "was not found");
        }



        return routeOpt.get().getComments().stream().map(this::map).collect(Collectors.toList());
    }

    private CommentViewModel map(Comment comment) {

        CommentViewModel commentViewModel = new CommentViewModel();
        commentViewModel.setCommentId(comment.getId());
        commentViewModel.setAuthor(comment.getAuthor().getUsername());
        commentViewModel.setCreated(comment.getCreated());
        commentViewModel.setTextContent(comment.getTextContent());
        commentViewModel.setCanDelete(true);
        commentViewModel.setCanDelete(true);

        return commentViewModel;
    }
}
