package com.example.servicehistory.model.binding;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class CarUpdateBindingModel {

    private Long id;
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

    public Long getId() {
        return id;
    }

    public CarUpdateBindingModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getBrand() {
        return brand;
    }

    public CarUpdateBindingModel setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public String getModel() {
        return model;
    }

    public CarUpdateBindingModel setModel(String model) {
        this.model = model;
        return this;
    }

    public Integer getYear() {
        return year;
    }

    public CarUpdateBindingModel setYear(Integer year) {
        this.year = year;
        return this;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public CarUpdateBindingModel setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public CarUpdateBindingModel setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public CarUpdateBindingModel setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
        return this;
    }
}
