package com.example.springintro.service;

import com.example.springintro.model.entity.Category;
import com.example.springintro.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void seedCategories() throws IOException {

        if (categoryRepository.count() > 0) {
            return;
        }

        Files.readAllLines(Path.of("src/main/resources/files/categories.txt"))
                .stream()
                .filter(r -> !r.isEmpty())
                .collect(Collectors.toList())
                .forEach(r -> {
                    Category category = new Category();
                    category.setName(r);

                    categoryRepository.save(category);
                });


    }

    @Override
    public Set<Category> getRandomCategories() {

        Set<Category> categories = new HashSet<>();
        int randInt = ThreadLocalRandom.current().nextInt(1, 3);

        for (int i = 0; i < randInt; i++) {
            long randomId = ThreadLocalRandom.current().nextLong(1, categoryRepository.count() + 1);

            categories.add(categoryRepository.findById(randomId).orElse(null));

        }

        return categories;
    }
}
