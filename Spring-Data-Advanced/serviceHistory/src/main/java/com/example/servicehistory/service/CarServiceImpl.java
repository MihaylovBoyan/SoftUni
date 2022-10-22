package com.example.servicehistory.service;

import com.example.servicehistory.model.binding.CarAddBindingModel;
import com.example.servicehistory.model.entity.CarEntity;
import com.example.servicehistory.model.service.CarAddServiceModel;
import com.example.servicehistory.model.view.CarView;
import com.example.servicehistory.repository.CarRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;
    private final ModelMapper modelMapper;

    public CarServiceImpl(CarRepository carRepository, ModelMapper modelMapper) {
        this.carRepository = carRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<CarView> findAllCars() {
        return carRepository.findAll().stream().map(c -> modelMapper.map(c, CarView.class)).collect(Collectors.toList());
    }

    @Override
    public void saveCar(CarAddBindingModel carAddBindingModel) {
        carRepository.save(modelMapper.map(carAddBindingModel, CarEntity.class));
    }

    @Override
    public void deleteById(Long id) {
        carRepository.deleteById(id);
    }

    @Override
    public CarView findById(Long id) {
        return carRepository.findById(id)
                .map(c -> modelMapper.map(c, CarView.class)).orElseThrow();
    }

    @Override
    public void updateCar(CarAddServiceModel carAddBindingModel) {

        CarEntity carEntity = carRepository.findById(carAddBindingModel.getId()).orElseThrow();

        carEntity.setBrand(carAddBindingModel.getBrand())
                .setImageUrl(carAddBindingModel.getImageUrl())
                .setModel(carAddBindingModel.getModel())
                .setYear(carAddBindingModel.getYear())
                .setPlateNumber(carAddBindingModel.getPlateNumber())
                .setShortDescription(carAddBindingModel.getShortDescription());

        carRepository.save(carEntity);
    }
}
