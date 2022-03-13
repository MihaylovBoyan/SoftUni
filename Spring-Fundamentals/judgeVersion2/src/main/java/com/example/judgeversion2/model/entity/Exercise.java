package com.example.judgeversion2.model.entity;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDateTime;

@Entity
@Table(name = "exercises")
public class Exercise extends BaseEntity{

    private String name;
    private LocalDateTime startedOn;
    private LocalDateTime dueDate;

    @Column(nullable = false)
//    @Length(min = 2)
    public String getName() {
        return name;
    }

    public Exercise setName(String name) {
        this.name = name;
        return this;
    }

    @Column(name = "started_on")
//    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
//    @PastOrPresent(message = "The date cannot be in the future")
    public LocalDateTime getStartedOn() {
        return startedOn;
    }

    public Exercise setStartedOn(LocalDateTime startedOn) {
        this.startedOn = startedOn;
        return this;
    }

    @Column(name = "due_date")
//    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
//    @FutureOrPresent(message = "The date cannot be in the past")
    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public Exercise setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
        return this;
    }
}
