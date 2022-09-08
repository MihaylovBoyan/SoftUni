package com.example.path.model.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "comments")
public class Comment extends BaseEntity{

    private Boolean approved;
    private String textContent;
    private User author;
    private Route route;
    private LocalDateTime created;

    @Column(nullable = false)
    public Boolean getApproved() {
        return approved;
    }

    public Comment setApproved(Boolean approved) {
        this.approved = approved;
        return this;
    }

    @Lob
    public String getTextContent() {
        return textContent;
    }

    public Comment setTextContent(String textContent) {
        this.textContent = textContent;
        return this;
    }

    @ManyToOne
    public User getAuthor() {
        return author;
    }

    public Comment setAuthor(User author) {
        this.author = author;
        return this;
    }

    @ManyToOne
    public Route getRoute() {
        return route;
    }

    public Comment setRoute(Route route) {
        this.route = route;
        return this;
    }

    @Column(nullable = false)
    public LocalDateTime getCreated() {
        return created;
    }

    public Comment setCreated(LocalDateTime created) {
        this.created = created;
        return this;
    }
}
