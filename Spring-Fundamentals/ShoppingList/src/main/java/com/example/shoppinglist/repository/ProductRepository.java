package com.example.shoppinglist.repository;

import com.example.shoppinglist.model.entity.Product;
import com.example.shoppinglist.model.entity.enums.CategoryNameEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("select sum (p.price) from Product p")
    BigDecimal findTotalProductsSum();

   // @Query("select c from Category c where c.name = 'categoryName'")
    List<Product> findAllByCategory_Name(CategoryNameEnum categoryName);

}
