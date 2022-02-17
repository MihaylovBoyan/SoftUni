package com.example.workshopp.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "companies")
public class Company extends BaseEntity{

    private String name;

    @Column(nullable = false)
    public String getName() {
        return name;
    }

    public Company setName(String name) {
        this.name = name;
        return this;
    }
}
