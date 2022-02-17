package com.example.workshopp.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "employees")
public class Employee extends BaseEntity {

    private String firstName;
    private String lastName;
    private Integer age;
    private Project project;

    @Column(nullable = false)
    public String getFirstName() {
        return firstName;
    }

    public Employee setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    @Column(nullable = false)
    public String getLastName() {
        return lastName;
    }

    public Employee setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    @Column(nullable = false)
    public Integer getAge() {
        return age;
    }

    public Employee setAge(Integer age) {
        this.age = age;
        return this;
    }

    @ManyToOne
    public Project getProject() {
        return project;
    }

    public Employee setProject(Project project) {
        this.project = project;
        return this;
    }
}
