package com.example.workshopp.model.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
public class CompanyDto {

    @XmlAttribute
    private String name;

    public String getName() {
        return name;
    }

    public CompanyDto setName(String name) {
        this.name = name;
        return this;
    }
}
