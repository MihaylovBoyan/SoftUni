package com.example.servicehistory.model.binding;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class CarAddBindingModel {

    @NotBlank
    private String brand;
    @NotBlank
    private String model;
    @Positive
    @NotNull
    private Integer year;
    @NotBlank
    private String plateNumber;
    @NotBlank
    private String imageUrl;

    private String shortDescription;

    public String getBrand() {
        return brand;
    }

    public CarAddBindingModel setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public String getModel() {
        return model;
    }

    public CarAddBindingModel setModel(String model) {
        this.model = model;
        return this;
    }

    public Integer getYear() {
        return year;
    }

    public CarAddBindingModel setYear(Integer year) {
        this.year = year;
        return this;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public CarAddBindingModel setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public CarAddBindingModel setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public CarAddBindingModel setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
        return this;
    }
}
