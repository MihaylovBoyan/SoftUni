package com.example.andreys.model.service;

import com.example.andreys.model.entity.enums.CategoryNameEnum;

public class CategoryServiceModel {

    private CategoryNameEnum name;
    private String description;

    public CategoryNameEnum getName() {
        return name;
    }

    public CategoryServiceModel setName(CategoryNameEnum name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public CategoryServiceModel setDescription(String description) {
        this.description = description;
        return this;
    }
}
