package com.example.xmlformat.model.dto;


import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "category")
@XmlAccessorType(XmlAccessType.FIELD)
public class CategorySeedDto {

    @XmlElement
    @Size(min = 3, max = 15)
    private String name;

    public String getName() {
        return name;
    }

    public CategorySeedDto setName(String name) {
        this.name = name;
        return this;
    }
}
