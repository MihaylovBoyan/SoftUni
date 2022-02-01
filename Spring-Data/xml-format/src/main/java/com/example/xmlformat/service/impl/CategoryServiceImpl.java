package com.example.xmlformat.service.impl;

import com.example.xmlformat.model.dto.CategorySeedDto;
import com.example.xmlformat.model.entity.Category;
import com.example.xmlformat.repository.CategoryRepository;
import com.example.xmlformat.service.CategoryService;
import com.example.xmlformat.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Component
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    public CategoryServiceImpl(CategoryRepository categoryRepository, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public void seedCategories(List<CategorySeedDto> categories) {

        categories
                .stream()
                .filter(validationUtil::isValid)
                .map(categorySeedDto -> modelMapper.map(categorySeedDto, Category.class))
                .forEach(categoryRepository::save);
    }

    @Override
    public long getEntityCount() {
        return categoryRepository.count();
    }

    @Override
    public Set<Category> randomCategories() {

        Set<Category> categories = new HashSet<>();
        long count = categoryRepository.count();

        for (int i = 0; i < 2; i++) {
            long rand = ThreadLocalRandom.current()
                    .nextLong(1, count);
            categories.add(categoryRepository.findById(rand).orElse(null));
        }
        return categories;
    }
}
