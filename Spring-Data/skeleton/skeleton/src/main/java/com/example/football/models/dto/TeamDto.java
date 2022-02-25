package com.example.football.models.dto;

import com.google.gson.annotations.Expose;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

public class TeamDto {

    @Expose
    private String name;
    @Expose
    private String stadiumName;
    @Expose
    private int fanBase;
    @Expose
    private String history;
    @Expose
    private String townName;

    @Size(min = 3)
    public String getName() {
        return name;
    }

    public TeamDto setName(String name) {
        this.name = name;
        return this;
    }

    @Size(min = 3)
    public String getStadiumName() {
        return stadiumName;
    }

    public TeamDto setStadiumName(String stadiumName) {
        this.stadiumName = stadiumName;
        return this;
    }

    @Min(1000)
    public int getFanBase() {
        return fanBase;
    }

    public TeamDto setFanBase(int fanBase) {
        this.fanBase = fanBase;
        return this;
    }

    @Size(min = 10)
    public String getHistory() {
        return history;
    }

    public TeamDto setHistory(String history) {
        this.history = history;
        return this;
    }

    public String getTownName() {
        return townName;
    }

    public TeamDto setTownName(String townName) {
        this.townName = townName;
        return this;
    }
}
