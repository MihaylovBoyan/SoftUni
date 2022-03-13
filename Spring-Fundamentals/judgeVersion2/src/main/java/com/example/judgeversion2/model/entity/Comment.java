package com.example.judgeversion2.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "comments")
public class Comment extends BaseEntity{

    private Integer score;
    private String textContext;
    private User author;
    private Homework homework;

    @Column
    public Integer getScore() {
        return score;
    }

    public Comment setScore(Integer score) {
        this.score = score;
        return this;
    }

    @Column(name = "text_context",columnDefinition = "TEXT")
    public String getTextContext() {
        return textContext;
    }

    public Comment setTextContext(String textContext) {
        this.textContext = textContext;
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
    public Homework getHomework() {
        return homework;
    }

    public Comment setHomework(Homework homework) {
        this.homework = homework;
        return this;
    }
}
