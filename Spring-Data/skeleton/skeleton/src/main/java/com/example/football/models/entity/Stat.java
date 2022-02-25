package com.example.football.models.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Positive;

@Entity
@Table(name = "stats")
public class Stat extends BaseEntity {

    private double shooting;
    private double passing;
    private double endurance;


    public double getShooting() {
        return shooting;
    }

    public Stat setShooting(double shooting) {
        this.shooting = shooting;
        return this;
    }


    public double getPassing() {
        return passing;
    }

    public Stat setPassing(double passing) {
        this.passing = passing;
        return this;
    }


    public double getEndurance() {
        return endurance;
    }

    public Stat setEndurance(double endurance) {
        this.endurance = endurance;
        return this;
    }
}
