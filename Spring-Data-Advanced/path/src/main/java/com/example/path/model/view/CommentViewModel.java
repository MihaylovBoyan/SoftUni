package com.example.path.model.view;

import com.example.path.model.entity.Route;
import com.example.path.model.entity.User;

import java.time.LocalDateTime;

public class CommentViewModel {

    private Long commentId;
    private String textContent;
    private String author;
    private LocalDateTime created;
    private boolean canApprove;
    private boolean canDelete;

    public Long getCommentId() {
        return commentId;
    }

    public CommentViewModel setCommentId(Long commentId) {
        this.commentId = commentId;
        return this;
    }

    public String getTextContent() {
        return textContent;
    }

    public CommentViewModel setTextContent(String textContent) {
        this.textContent = textContent;
        return this;
    }

    public String getAuthor() {
        return author;
    }

    public CommentViewModel setAuthor(String author) {
        this.author = author;
        return this;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public CommentViewModel setCreated(LocalDateTime created) {
        this.created = created;
        return this;
    }

    public boolean isCanApprove() {
        return canApprove;
    }

    public CommentViewModel setCanApprove(boolean canApprove) {
        this.canApprove = canApprove;
        return this;
    }

    public boolean isCanDelete() {
        return canDelete;
    }

    public CommentViewModel setCanDelete(boolean canDelete) {
        this.canDelete = canDelete;
        return this;
    }
}
