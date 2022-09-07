package com.example.path.web;

import com.example.path.model.binding.NewCommentBindingModel;
import com.example.path.model.service.CommentServiceModel;
import com.example.path.model.validation.ApiError;
import com.example.path.model.view.CommentViewModel;
import com.example.path.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.security.Principal;
import java.util.List;

@RestController
public class CommentRestController {

    private final CommentService commentService;

    public CommentRestController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/api/{routeId}/comments")
    public ResponseEntity<List<CommentViewModel>> getComments(@PathVariable Long routeId, Principal principal) {

        return ResponseEntity.ok(commentService.getComments(routeId));
    }

    @PostMapping("/api/{routeId}/comments")
    public ResponseEntity<CommentViewModel> newComment(@PathVariable Long routeId,
                                                       @AuthenticationPrincipal UserDetails principal,
                                                       @RequestBody @Valid NewCommentBindingModel newCommentBindingModel) {
//easier with modelMapper
        CommentServiceModel commentServiceModel = new CommentServiceModel();
        commentServiceModel
                .setMessage(newCommentBindingModel.getMessage())
                .setCreator(principal.getUsername())
                .setRouteId(routeId);

        CommentViewModel commentViewModel = commentService.createComment(commentServiceModel);

        URI locationOfNewComment = URI.create(String.format("/api/%s/comments/%s", routeId, commentViewModel.getCommentId()));

        return ResponseEntity.created(locationOfNewComment).body(commentViewModel);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> onValidationFailure(MethodArgumentNotValidException exc) {

        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST);
        exc.getFieldErrors().forEach(fe -> apiError.addFieldWithError(fe.getField()));

        return ResponseEntity.badRequest().body(apiError);
    }

}
