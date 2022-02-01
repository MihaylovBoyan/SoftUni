package com.example.xmlformat.service;

import com.example.xmlformat.model.dto.CategorySeedDto;
import com.example.xmlformat.model.entity.Category;

import java.util.List;
import java.util.Set;

public interface CategoryService {
    void seedCategories(List<CategorySeedDto> categories);

    long getEntityCount();

    Set<Category> randomCategories();

}
