package com.example.football.models.entity;

import com.example.football.models.entity.enums.Position;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.time.LocalDate;

@Entity
@Table(name = "players")
public class Player extends BaseEntity {

    private String firstName;
    private String lastName;
    private String email;
    private LocalDate birthDate;
    private Position position;
    private Stat statId;
    private Team teamId;
    private Town townId;


    public String getFirstName() {
        return firstName;
    }

    public Player setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Player setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    @Column(unique = true)
    public String getEmail() {
        return email;
    }

    public Player setEmail(String email) {
        this.email = email;
        return this;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public Player setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    @Enumerated
    public Position getPosition() {
        return position;
    }

    public Player setPosition(Position position) {
        this.position = position;
        return this;
    }

    @ManyToOne
    public Stat getStatId() {
        return statId;
    }

    public Player setStatId(Stat statId) {
        this.statId = statId;
        return this;
    }

    @ManyToOne
    public Team getTeamId() {
        return teamId;
    }

    public Player setTeamId(Team teamId) {
        this.teamId = teamId;
        return this;
    }

    @ManyToOne
    public Town getTownId() {
        return townId;
    }

    public Player setTownId(Town townId) {
        this.townId = townId;
        return this;
    }
}
