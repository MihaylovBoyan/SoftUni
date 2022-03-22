package com.example.mobilele.model.view;

import com.example.mobilele.model.entity.enums.Engine;
import com.example.mobilele.model.entity.enums.Transmission;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

public class OfferSummaryViewModel {

    private Engine engine;
    private String imageUrl;
    private int mileage;
    private BigDecimal price;
    private int year;
    private Transmission transmission;

    public Engine getEngine() {
        return engine;
    }

    public OfferSummaryViewModel setEngine(Engine engine) {
        this.engine = engine;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public OfferSummaryViewModel setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public int getMileage() {
        return mileage;
    }

    public OfferSummaryViewModel setMileage(int mileage) {
        this.mileage = mileage;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public OfferSummaryViewModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public int getYear() {
        return year;
    }

    public OfferSummaryViewModel setYear(int year) {
        this.year = year;
        return this;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public OfferSummaryViewModel setTransmission(Transmission transmission) {
        this.transmission = transmission;
        return this;
    }
}
