package com.example.mobi.model.view;

import com.example.mobi.model.entity.ModelEntity;
import com.example.mobi.model.entity.UserEntity;
import com.example.mobi.model.entity.enums.EngineEnum;
import com.example.mobi.model.entity.enums.TransmissionEnum;

import java.time.Instant;

public class OfferDetailsView {

    private Long id;
    private int year;
    private ModelEntity model;
    private int mileage;
    private int price;
    private EngineEnum engine;
    private TransmissionEnum transmission;
    private Instant created;
    private Instant modified;
    private UserEntity seller;
    private String imageUrl;

    public Long getId() {
        return id;
    }

    public OfferDetailsView setId(Long id) {
        this.id = id;
        return this;
    }

    public int getMileage() {
        return mileage;
    }

    public OfferDetailsView setMileage(int mileage) {
        this.mileage = mileage;
        return this;
    }

    public int getPrice() {
        return price;
    }

    public OfferDetailsView setPrice(int price) {
        this.price = price;
        return this;
    }

    public EngineEnum getEngine() {
        return engine;
    }

    public OfferDetailsView setEngine(EngineEnum engine) {
        this.engine = engine;
        return this;
    }

    public Instant getCreated() {
        return created;
    }

    public OfferDetailsView setCreated(Instant created) {
        this.created = created;
        return this;
    }

    public Instant getModified() {
        return modified;
    }

    public OfferDetailsView setModified(Instant modified) {
        this.modified = modified;
        return this;
    }

    public UserEntity getSeller() {
        return seller;
    }

    public OfferDetailsView setSeller(UserEntity seller) {
        this.seller = seller;
        return this;
    }

    public TransmissionEnum getTransmission() {
        return transmission;
    }

    public OfferDetailsView setTransmission(TransmissionEnum transmission) {
        this.transmission = transmission;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public OfferDetailsView setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public int getYear() {
        return year;
    }

    public OfferDetailsView setYear(int year) {
        this.year = year;
        return this;
    }

    public ModelEntity getModel() {
        return model;
    }

    public OfferDetailsView setModel(ModelEntity model) {
        this.model = model;
        return this;
    }
}
