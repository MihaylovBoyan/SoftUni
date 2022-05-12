package com.example.andreys.init;

import com.example.andreys.model.entity.Category;
import com.example.andreys.model.entity.enums.CategoryNameEnum;
import com.example.andreys.repository.CategoryRepository;
import com.example.andreys.service.CategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DBInit implements CommandLineRunner {

    private final CategoryService categoryService;

    public DBInit(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    public void run(String... args) throws Exception {
       categoryService.init();
    }
}
