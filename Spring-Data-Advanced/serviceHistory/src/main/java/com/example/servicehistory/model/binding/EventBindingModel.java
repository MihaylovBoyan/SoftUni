package com.example.servicehistory.model.binding;

import javax.persistence.Column;
import java.time.LocalDate;

public class EventBindingModel {

    private LocalDate date;
    private Integer mileage;
    private String text;
    private boolean isPeriodical;
    private LocalDate nextDate;
    private Integer nextChange;

    public LocalDate getDate() {
        return date;
    }

    public EventBindingModel setDate(LocalDate date) {
        this.date = date;
        return this;
    }

    public Integer getMileage() {
        return mileage;
    }

    public EventBindingModel setMileage(Integer mileage) {
        this.mileage = mileage;
        return this;
    }

    public String getText() {
        return text;
    }

    public EventBindingModel setText(String text) {
        this.text = text;
        return this;
    }

    public boolean isPeriodical() {
        return isPeriodical;
    }

    public EventBindingModel setPeriodical(boolean periodical) {
        isPeriodical = periodical;
        return this;
    }

    public LocalDate getNextDate() {
        return nextDate;
    }

    public EventBindingModel setNextDate(LocalDate nextDate) {
        this.nextDate = nextDate;
        return this;
    }

    public Integer getNextChange() {
        return nextChange;
    }

    public EventBindingModel setNextChange(Integer nextChange) {
        this.nextChange = nextChange;
        return this;
    }
}
