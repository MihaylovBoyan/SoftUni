package com.example.football.models.entity;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "towns")
public class Town extends BaseEntity{

    private String name;
    private int population;
    private String travelGuide;

    @Column(unique = true)
    @Length(min = 2)
    public String getName() {
        return name;
    }

    public Town setName(String name) {
        this.name = name;
        return this;
    }

    @Column
    public int getPopulation() {
        return population;
    }

    public Town setPopulation(int population) {
        this.population = population;
        return this;
    }

    @Column(columnDefinition = "TEXT")
    public String getTravelGuide() {
        return travelGuide;
    }

    public Town setTravelGuide(String travelGuide) {
        this.travelGuide = travelGuide;
        return this;
    }
}
