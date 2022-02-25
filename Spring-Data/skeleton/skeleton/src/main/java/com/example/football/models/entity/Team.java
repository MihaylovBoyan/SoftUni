package com.example.football.models.entity;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "teams")
public class Team extends BaseEntity{

    private String name;
    private String stadiumName;
    private int fanBase;
    private String history;
    private Town town;

    @Column(unique = true)
    public String getName() {
        return name;
    }

    public Team setName(String name) {
        this.name = name;
        return this;
    }

    @Length(min = 3)
    public String getStadiumName() {
        return stadiumName;
    }

    public Team setStadiumName(String stadiumName) {
        this.stadiumName = stadiumName;
        return this;
    }

    @Column
    public int getFanBase() {
        return fanBase;
    }

    public Team setFanBase(int fanBase) {
        this.fanBase = fanBase;
        return this;
    }

    @Column(columnDefinition = "TEXT")
    public String getHistory() {
        return history;
    }

    public Team setHistory(String history) {
        this.history = history;
        return this;
    }

    @ManyToOne
    public Town getTown() {
        return town;
    }

    public Team setTown(Town town) {
        this.town = town;
        return this;
    }
}
