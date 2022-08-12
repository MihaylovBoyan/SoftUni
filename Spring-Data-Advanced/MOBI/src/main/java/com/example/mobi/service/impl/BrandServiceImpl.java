package com.example.mobi.service.impl;

import com.example.mobi.model.entity.BrandEntity;
import com.example.mobi.repository.BrandRepository;
import com.example.mobi.service.BrandService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {

    private final BrandRepository brandRepository;

    public BrandServiceImpl(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }


    @Override
    public List<BrandEntity> findAll() {
        return brandRepository.findAll();
    }
}
