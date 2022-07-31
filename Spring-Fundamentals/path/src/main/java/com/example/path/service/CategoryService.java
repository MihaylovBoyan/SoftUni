package com.example.path.service;

import com.example.path.model.entity.Category;
import com.example.path.model.entity.enums.CategoryNameEnum;

public interface CategoryService {


    Category findByName(CategoryNameEnum c);
}
