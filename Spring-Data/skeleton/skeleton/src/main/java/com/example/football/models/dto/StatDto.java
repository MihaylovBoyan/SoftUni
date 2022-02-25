package com.example.football.models.dto;

import javax.validation.constraints.Positive;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class StatDto {

    private double passing;
    private double shooting;
    private double endurance;

    @Positive
    public double getPassing() {
        return passing;
    }

    public StatDto setPassing(double passing) {
        this.passing = passing;
        return this;
    }

    @Positive
    public double getShooting() {
        return shooting;
    }

    public StatDto setShooting(double shooting) {
        this.shooting = shooting;
        return this;
    }

    @Positive
    public double getEndurance() {
        return endurance;
    }

    public StatDto setEndurance(double endurance) {
        this.endurance = endurance;
        return this;
    }

//    @Positive
//    public long getStatId() {
//        return id;
//    }
//
//    public StatDto setStatId(long id) {
//        this.id = id;
//        return this;
//    }
}