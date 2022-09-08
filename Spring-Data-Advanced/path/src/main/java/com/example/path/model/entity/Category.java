package com.example.path.model.entity;

import com.example.path.model.entity.enums.CategoryNameEnum;

import javax.persistence.*;

import static javax.persistence.EnumType.STRING;

@Entity
@Table(name = "categories")
public class Category extends BaseEntity{

    private String description;
    private CategoryNameEnum name;

    @Lob
    public String getDescription() {
        return description;
    }

    public Category setDescription(String description) {
        this.description = description;
        return this;
    }

    @Enumerated(STRING)
    public CategoryNameEnum getName() {
        return name;
    }

    public Category setName(CategoryNameEnum name) {
        this.name = name;
        return this;
    }
}
