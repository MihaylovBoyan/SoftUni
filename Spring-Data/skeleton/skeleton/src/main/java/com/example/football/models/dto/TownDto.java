package com.example.football.models.dto;

import com.google.gson.annotations.Expose;

import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class TownDto {

    @Expose
    private String name;
    @Expose
    private int population;
    @Expose
    private String travelGuide;

    @Size(min = 3)
    public String getName() {
        return name;
    }

    public TownDto setName(String name) {
        this.name = name;
        return this;
    }

    @Positive
    public int getPopulation() {
        return population;
    }

    public TownDto setPopulation(int population) {
        this.population = population;
        return this;
    }
    @Size(min = 10)
    public String getTravelGuide() {
        return travelGuide;
    }

    public TownDto setTravelGuide(String travelGuide) {
        this.travelGuide = travelGuide;
        return this;
    }
}
