package com.example.workshopp.model.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class EmployeeDto {

    @XmlElement(name = "first-name")
    private String firstName;
    @XmlElement(name = "last-name")
    private String lastName;
    @XmlElement(name = "age")
    private Integer age;
    @XmlElement(name = "project")
    private ProjectDto project;

    public String getFirstName() {
        return firstName;
    }

    public EmployeeDto setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public EmployeeDto setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public EmployeeDto setAge(Integer age) {
        this.age = age;
        return this;
    }

    public ProjectDto getProject() {
        return project;
    }

    public EmployeeDto setProject(ProjectDto project) {
        this.project = project;
        return this;
    }
}
