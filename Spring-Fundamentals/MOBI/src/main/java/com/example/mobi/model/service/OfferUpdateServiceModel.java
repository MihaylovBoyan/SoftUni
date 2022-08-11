package com.example.mobi.model.service;

import com.example.mobi.model.entity.enums.EngineEnum;
import com.example.mobi.model.entity.enums.TransmissionEnum;

import java.time.Instant;

public class OfferUpdateServiceModel {

    private Long id;
    private String description;
    private int year;
    private int mileage;
    private int price;
    private EngineEnum engine;
    private TransmissionEnum transmission;
    private String imageUrl;
    private Instant modified;

    public Long getId() {
        return id;
    }

    public OfferUpdateServiceModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public OfferUpdateServiceModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public int getYear() {
        return year;
    }

    public OfferUpdateServiceModel setYear(int year) {
        this.year = year;
        return this;
    }

    public int getMileage() {
        return mileage;
    }

    public OfferUpdateServiceModel setMileage(int mileage) {
        this.mileage = mileage;
        return this;
    }

    public int getPrice() {
        return price;
    }

    public OfferUpdateServiceModel setPrice(int price) {
        this.price = price;
        return this;
    }

    public EngineEnum getEngine() {
        return engine;
    }

    public OfferUpdateServiceModel setEngine(EngineEnum engine) {
        this.engine = engine;
        return this;
    }

    public TransmissionEnum getTransmission() {
        return transmission;
    }

    public OfferUpdateServiceModel setTransmission(TransmissionEnum transmission) {
        this.transmission = transmission;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public OfferUpdateServiceModel setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public Instant getModified() {
        return modified;
    }

    public OfferUpdateServiceModel setModified(Instant modified) {
        this.modified = modified;
        return this;
    }
}
