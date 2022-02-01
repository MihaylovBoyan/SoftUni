package com.example.xmlformat.service;

import com.example.xmlformat.model.dto.ProductSeedDto;
import com.example.xmlformat.model.dto.ProductViewRootDto;

import java.util.List;

public interface ProductService {
    long getCount();

    void seedProducts(List<ProductSeedDto> products);

    ProductViewRootDto findInRange();
}
