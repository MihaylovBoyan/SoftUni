package com.example.shoppinglist.service.impl;

import com.example.shoppinglist.model.entity.Category;
import com.example.shoppinglist.model.entity.enums.CategoryNameEnum;
import com.example.shoppinglist.repository.CategoryRepository;
import com.example.shoppinglist.service.CategoryService;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void initCategories() {

        if (categoryRepository.count() == 0) {

            CategoryNameEnum[] values = CategoryNameEnum.values();

            for (CategoryNameEnum value : values) {
                Category category = new Category();
                category.setName(value).setDescription("Description for " + value.name());
                categoryRepository.save(category);
            }

        }
    }

    @Override
    public Category findByName(CategoryNameEnum name) {
        return categoryRepository.findByName(name).orElse(null);
    }
}
