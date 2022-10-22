package com.example.servicehistory.model.service;

public class CarAddServiceModel {

    private Long id;
    private String brand;
    private String model;
    private Integer year;
    private String plateNumber;
    private String imageUrl;
    private String shortDescription;

    public Long getId() {
        return id;
    }

    public CarAddServiceModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getBrand() {
        return brand;
    }

    public CarAddServiceModel setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public String getModel() {
        return model;
    }

    public CarAddServiceModel setModel(String model) {
        this.model = model;
        return this;
    }

    public Integer getYear() {
        return year;
    }

    public CarAddServiceModel setYear(Integer year) {
        this.year = year;
        return this;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public CarAddServiceModel setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public CarAddServiceModel setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public CarAddServiceModel setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
        return this;
    }
}
