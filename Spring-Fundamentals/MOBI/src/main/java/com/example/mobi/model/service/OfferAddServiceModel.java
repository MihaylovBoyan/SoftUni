package com.example.mobi.model.service;

import com.example.mobi.model.entity.enums.EngineEnum;
import com.example.mobi.model.entity.enums.TransmissionEnum;

public class OfferAddServiceModel {

    private Long id;
    private String model;
    private String description;
    private Integer year;
    private Integer mileage;
    private Integer price;
    private EngineEnum engine;
    private TransmissionEnum transmission;
    private String imageUrl;


    public Long getId() {
        return id;
    }

    public OfferAddServiceModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public OfferAddServiceModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public Integer getYear() {
        return year;
    }

    public OfferAddServiceModel setYear(Integer year) {
        this.year = year;
        return this;
    }

    public Integer getMileage() {
        return mileage;
    }

    public OfferAddServiceModel setMileage(Integer mileage) {
        this.mileage = mileage;
        return this;
    }

    public Integer getPrice() {
        return price;
    }

    public OfferAddServiceModel setPrice(Integer price) {
        this.price = price;
        return this;
    }

    public EngineEnum getEngine() {
        return engine;
    }

    public OfferAddServiceModel setEngine(EngineEnum engine) {
        this.engine = engine;
        return this;
    }

    public TransmissionEnum getTransmission() {
        return transmission;
    }

    public OfferAddServiceModel setTransmission(TransmissionEnum transmission) {
        this.transmission = transmission;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public OfferAddServiceModel setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public String getModel() {
        return model;
    }

    public OfferAddServiceModel setModel(String model) {
        this.model = model;
        return this;
    }
}
