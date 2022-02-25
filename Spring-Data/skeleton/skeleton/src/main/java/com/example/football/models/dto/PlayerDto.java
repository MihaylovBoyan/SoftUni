package com.example.football.models.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class PlayerDto {

    @XmlElement(name = "first-name")
    private String firstName;
    @XmlElement(name = "last-name")
    private String lastName;
    private String email;
    @XmlElement(name = "birth-date")
    private String birthDate;
    private String position;
    @XmlElement(name = "town")
    private TownNameDto town;
    @XmlElement(name = "team")
    private TeamDto name;
    @XmlElement(name = "stat")
    private StatIdDto id;

    @Size(min = 2)
    public String getFirstName() {
        return firstName;
    }

    public PlayerDto setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    @Size(min = 2)
    public String getLastName() {
        return lastName;
    }

    public PlayerDto setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    @NotBlank
    public String getPosition() {
        return position;
    }

    public PlayerDto setPosition(String position) {
        this.position = position;
        return this;
    }

    public TownNameDto getTown() {
        return town;
    }

    public PlayerDto setTown(TownNameDto town) {
        this.town = town;
        return this;
    }

    @NotNull
    public TeamDto getName() {
        return name;
    }

    public PlayerDto setName(TeamDto name) {
        this.name = name;
        return this;
    }

    public StatIdDto getId() {
        return id;
    }

    public PlayerDto setId(StatIdDto id) {
        this.id = id;
        return this;
    }

    @Email
    public String getEmail() {
        return email;
    }

    public PlayerDto setEmail(String email) {
        this.email = email;
        return this;
    }

    @NotNull
    public String getBirthDate() {
        return birthDate;
    }

    public PlayerDto setBirthDate(String birthDate) {
        this.birthDate = birthDate;
        return this;
    }
}
