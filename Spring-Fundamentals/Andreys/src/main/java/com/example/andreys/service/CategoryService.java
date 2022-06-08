package com.example.andreys.service;

import com.example.andreys.model.entity.Category;
import com.example.andreys.model.entity.enums.CategoryNameEnum;

public interface CategoryService {
    void init();

    Category findByCategoryName(CategoryNameEnum categoryNameEnum);
}
