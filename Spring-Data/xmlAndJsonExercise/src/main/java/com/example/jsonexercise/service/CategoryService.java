package com.example.jsonexercise.service;

import com.example.jsonexercise.model.dto.CategorySeedDtoXml;
import com.example.jsonexercise.model.entity.Category;

import java.io.IOException;
import java.util.List;
import java.util.Set;

public interface CategoryService {
    void seedCategoriesXml() throws IOException;

    Set<Category> findRandomCategories();

    void seedCategoriesXml(List<CategorySeedDtoXml> categories);

    long getEntityCount();

}
