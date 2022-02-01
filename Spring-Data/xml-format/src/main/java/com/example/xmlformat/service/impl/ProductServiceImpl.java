package com.example.xmlformat.service.impl;

import com.example.xmlformat.model.dto.ProductSeedDto;
import com.example.xmlformat.model.dto.ProductViewRootDto;
import com.example.xmlformat.model.dto.ProductWithSellerDto;
import com.example.xmlformat.model.entity.Product;
import com.example.xmlformat.repository.ProductRepository;
import com.example.xmlformat.service.CategoryService;
import com.example.xmlformat.service.ProductService;
import com.example.xmlformat.service.UserService;
import com.example.xmlformat.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final CategoryService categoryService;
    private final UserService userService;


    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper, ValidationUtil validationUtil, CategoryService categoryService, UserService userService) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.categoryService = categoryService;
        this.userService = userService;
    }

    @Override
    public long getCount() {
        return productRepository.count();
    }

    @Override
    public void seedProducts(List<ProductSeedDto> products) {

        products
                .stream()
                .filter(validationUtil::isValid)
                .map(productSeedDto -> {

                    Product product = modelMapper.map(productSeedDto, Product.class);
                    product.setCategories(categoryService.randomCategories());
                    product.setSeller(userService.getRandomUser());

                    if (product.getPrice().compareTo(BigDecimal.valueOf(700)) > 0) {
                        product.setBuyer(userService.getRandomUser());
                    }

                    return product;
                })
                .forEach(productRepository::save);


    }

    @Override
    public ProductViewRootDto findInRange() {

        ProductViewRootDto rootDto = new ProductViewRootDto();

        rootDto
                .setProducts(productRepository
                        .findAllByPriceBetweenAndBuyerIsNull(BigDecimal.valueOf(500L), BigDecimal.valueOf(1000L))
                        .stream()
                        .map(product -> {
                            ProductWithSellerDto productWithSellerDto = modelMapper.map(product, ProductWithSellerDto.class);
                            productWithSellerDto.setSeller(String.format("%s %s",
                                    product.getSeller().getFirstName() == null ? "" : product.getSeller().getFirstName(),
                                    product.getSeller().getLastName()));
                            return productWithSellerDto;
                        })
                        .collect(Collectors.toList()));


        return rootDto;
    }


}
