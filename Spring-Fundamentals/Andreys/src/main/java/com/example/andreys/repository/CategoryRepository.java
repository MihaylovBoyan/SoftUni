package com.example.andreys.repository;

import com.example.andreys.model.entity.Category;
import com.example.andreys.model.entity.enums.CategoryNameEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {


    Optional<Category> findByName(CategoryNameEnum name);
}
