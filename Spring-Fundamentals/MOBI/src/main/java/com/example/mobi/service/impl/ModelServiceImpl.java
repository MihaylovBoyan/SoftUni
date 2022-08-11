package com.example.mobi.service.impl;

import com.example.mobi.model.entity.ModelEntity;
import com.example.mobi.repository.ModelRepository;
import com.example.mobi.service.ModelService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModelServiceImpl implements ModelService {

    private final ModelRepository modelRepository;

    public ModelServiceImpl(ModelRepository modelRepository) {
        this.modelRepository = modelRepository;
    }


    @Override
    public List<String> findAllNames() {
        return modelRepository.findAllNames();
    }
}
