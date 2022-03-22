package com.example.mobilele.service.impl;

import com.example.mobilele.model.entity.Brand;
import com.example.mobilele.model.entity.Model;
import com.example.mobilele.model.view.BrandViewModel;
import com.example.mobilele.model.view.ModelViewModel;
import com.example.mobilele.repository.BrandRepository;
import com.example.mobilele.repository.ModelRepository;
import com.example.mobilele.service.BrandService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BrandServiceImpl implements BrandService {

    private final BrandRepository brandRepository;
    private final ModelMapper modelMapper;
    private final ModelRepository modelRepository;

    public BrandServiceImpl(BrandRepository brandRepository, ModelMapper modelMapper, ModelRepository modelRepository) {
        this.brandRepository = brandRepository;
        this.modelMapper = modelMapper;
        this.modelRepository = modelRepository;
    }

    @Override
    public List<BrandViewModel> getAllBrands() {

        List<BrandViewModel> result = new ArrayList<>();
        List<Model> allModels = modelRepository.findAll();

        allModels.forEach(model -> {
            Brand brand = model.getBrand();
            Optional<BrandViewModel> brandViewModelOpt = findByName(result, brand.getName());

            if(!brandViewModelOpt.isPresent()){
                BrandViewModel newBrandViewModel = new BrandViewModel();
                modelMapper.map(brand, newBrandViewModel);
                result.add(newBrandViewModel);
                brandViewModelOpt = Optional.of(newBrandViewModel);
            }

            ModelViewModel newModelViewModel = new ModelViewModel();

            modelMapper.map(model,newModelViewModel);
            brandViewModelOpt.get().addModel(newModelViewModel);


        });


        return result;
    }


    private static Optional<BrandViewModel> findByName(List<BrandViewModel> allModels, String name){

       return allModels.stream()
                .filter(m -> m.getName().equals(name))
                .findAny();

    }




}
