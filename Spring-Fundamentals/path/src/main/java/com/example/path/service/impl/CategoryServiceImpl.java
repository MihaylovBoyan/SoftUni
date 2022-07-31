package com.example.path.service.impl;

import com.example.path.model.entity.Category;
import com.example.path.model.entity.enums.CategoryNameEnum;
import com.example.path.repository.CategoryRepository;
import com.example.path.service.CategoryService;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category findByName(CategoryNameEnum c) {
        return categoryRepository.findByName(c).orElse(null);
    }
}
