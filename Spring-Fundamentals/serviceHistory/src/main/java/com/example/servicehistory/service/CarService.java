package com.example.servicehistory.service;

import com.example.servicehistory.model.binding.CarAddBindingModel;
import com.example.servicehistory.model.service.CarAddServiceModel;
import com.example.servicehistory.model.view.CarView;

import java.util.List;

public interface CarService {
    List<CarView> findAllCars();

    void saveCar(CarAddBindingModel carAddBindingModel);

    void deleteById(Long id);

    CarView findById(Long id);

    void updateCar(CarAddServiceModel carAddBindingModel);
}
