package com.example.xmlformat.model.dto;

import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserSeedDto {

    @XmlAttribute(name = "first-name")
    private String firstName;
    @XmlAttribute(name = "last-name")
    private String lastName;
    @XmlAttribute(name = "age")
    private Integer age;


    public String getFirstName() {
        return firstName;
    }

    public UserSeedDto setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    @Size(min = 3)
    public String getLastName() {
        return lastName;
    }

    public UserSeedDto setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public UserSeedDto setAge(Integer age) {
        this.age = age;
        return this;
    }
}
