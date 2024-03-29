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

    @Column(nullable = false, unique = true)
    public String getName() {
        return name;
    }

    public Exercise setName(String name) {
        this.name = name;
        return this;
    }

    @Column(name = "started_on")
    public LocalDateTime getStartedOn() {
        return startedOn;
    }

    public Exercise setStartedOn(LocalDateTime startedOn) {
        this.startedOn = startedOn;
        return this;
    }

    @Column(name = "due_date")
    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public Exercise setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
        return this;
    }
}
