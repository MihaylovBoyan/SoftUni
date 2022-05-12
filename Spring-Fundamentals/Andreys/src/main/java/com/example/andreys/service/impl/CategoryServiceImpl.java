package com.example.andreys.service.impl;

import com.example.andreys.model.entity.Category;
import com.example.andreys.model.entity.enums.CategoryNameEnum;
import com.example.andreys.repository.CategoryRepository;
import com.example.andreys.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    public CategoryServiceImpl(CategoryRepository categoryRepository, ModelMapper modelMapper) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void init() {
        if (categoryRepository.count() <= 0) {

            CategoryNameEnum[] values = CategoryNameEnum.values();
            for (CategoryNameEnum value : values) {
                Category category = new Category();
                category.setName(value);
                category.setDescription("best description evcer lorem ipsum");
                categoryRepository.save(category);
            }

        }
    }
}
