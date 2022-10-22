package com.example.servicehistory.model.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private LocalDate date;
    @Column(nullable = false)
    private Integer mileage;
    @Column(nullable = false)
    private String text;
    @Column(nullable = false)
    private boolean isPeriodical;
    @Column(nullable = false)
    private LocalDate nextDate;
    @Column(nullable = false)
    private Integer nextChange;
    @ManyToOne
    private CarEntity car;

    public LocalDate getDate() {
        return date;
    }

    public Event setDate(LocalDate date) {
        this.date = date;
        return this;
    }

    public Integer getMileage() {
        return mileage;
    }

    public Event setMileage(Integer mileage) {
        this.mileage = mileage;
        return this;
    }

    public String getText() {
        return text;
    }

    public Event setText(String text) {
        this.text = text;
        return this;
    }

    public boolean isPeriodical() {
        return isPeriodical;
    }

    public Event setPeriodical(boolean periodical) {
        isPeriodical = periodical;
        return this;
    }

    public LocalDate getNextDate() {
        return nextDate;
    }

    public Event setNextDate(LocalDate nextDate) {
        this.nextDate = nextDate;
        return this;
    }

    public Integer getNextChange() {
        return nextChange;
    }

    public Event setNextChange(Integer nextChange) {
        this.nextChange = nextChange;
        return this;
    }

    public Long getId() {
        return id;
    }

    public Event setId(Long id) {
        this.id = id;
        return this;
    }

    public CarEntity getCar() {
        return car;
    }

    public Event setCar(CarEntity car) {
        this.car = car;
        return this;
    }
}
