package com.example.football.models.dto;

import javax.validation.constraints.Positive;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class StatIdDto {

    private long id;

    @Positive
    public long getId() {
        return id;
    }

    public StatIdDto setId(long id) {
        this.id = id;
        return this;
    }
}
