package com.example.jsonexercise.service;

import com.example.jsonexercise.model.dto.ProductNameAndPriceDto;
import com.example.jsonexercise.model.dto.ProductViewRootDto;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public interface ProductService {
    void seedProducts() throws IOException;

    List<ProductNameAndPriceDto> findAllProductsInRange(BigDecimal lowerBound, BigDecimal upperBound);

    long getCount();

    ProductViewRootDto findProductInRangeWithoutBuyer();
}
