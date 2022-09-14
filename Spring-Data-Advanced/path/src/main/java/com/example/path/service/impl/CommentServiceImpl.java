package com.example.path.service.impl;

import com.example.path.model.entity.Comment;
import com.example.path.model.entity.Route;
import com.example.path.model.service.CommentServiceModel;
import com.example.path.model.view.CommentViewModel;
import com.example.path.repository.CommentRepository;
import com.example.path.repository.RouteRepository;
import com.example.path.repository.UserRepository;
import com.example.path.service.CommentService;
import com.example.path.service.exceptions.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final RouteRepository routeRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public CommentServiceImpl(CommentRepository commentRepository, RouteRepository routeRepository, UserRepository userRepository, ModelMapper modelMapper) {
        this.commentRepository = commentRepository;
        this.routeRepository = routeRepository;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public CommentViewModel createComment(CommentServiceModel commentServiceModel) {

      //  Objects.requireNonNull(commentServiceModel.getCreator());

        Comment comment = new Comment();
        comment
                .setCreated(LocalDateTime.now())
                .setApproved(false)
                .setRoute(routeRepository.findById(commentServiceModel.getRouteId()).orElseThrow(() -> new ObjectNotFoundException("Route with id does not exists")))
                .setTextContent(commentServiceModel.getMessage())
                .setAuthor(userRepository.findByEmail(commentServiceModel.getCreator()).orElseThrow());

        commentRepository.save(comment);

        return map(comment);
    }

//    private CommentViewModel mapAsComment(Comment comment) {
//
//
//        new CommentViewModel()
//                .setCommentId(comment.getId())
//                .setMessage(comment.getTextContent())
//                .setUser(comment.getAuthor().getUsername())
//                .setCreated(comment.getCreated())
//                .setCanDelete(false)
//                .setCanApprove(false);
//
//
//    }

    @Transactional
    @Override
    public List<CommentViewModel> getComments(Long id) {

        Optional<Route> routeOpt = routeRepository.findById(id);

        if (routeOpt.isEmpty()) {
            throw new ObjectNotFoundException("Root with id" + id + "was not found");
        }


        return routeOpt.get().getComments().stream().map(this::map).collect(Collectors.toList());
    }

    private CommentViewModel map(Comment comment) {

        CommentViewModel commentViewModel = new CommentViewModel();
        commentViewModel.setCommentId(comment.getId());
        commentViewModel.setUser(comment.getAuthor().getUsername());
        commentViewModel.setCreated(comment.getCreated());
        commentViewModel.setMessage(comment.getTextContent());
        commentViewModel.setCanDelete(true);
        commentViewModel.setCanDelete(true);

        return commentViewModel;
    }
}
