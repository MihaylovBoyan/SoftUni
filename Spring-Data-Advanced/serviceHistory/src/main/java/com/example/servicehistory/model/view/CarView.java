package com.example.servicehistory.model.view;

import com.example.servicehistory.model.entity.CarEntity;
import com.example.servicehistory.model.entity.Event;

import javax.persistence.Column;
import java.util.List;

public class CarView {

    private Long id;
    private String brand;
    private String model;
    private Integer year;
    private String plateNumber;
    private String imageUrl;
    private String shortDescription;
    private List<Event> events;

    public Long getId() {
        return id;
    }

    public CarView setId(Long id) {
        this.id = id;
        return this;
    }

    public String getBrand() {
        return brand;
    }

    public CarView setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public String getModel() {
        return model;
    }

    public CarView setModel(String model) {
        this.model = model;
        return this;
    }

    public Integer getYear() {
        return year;
    }

    public CarView setYear(Integer year) {
        this.year = year;
        return this;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public CarView setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public CarView setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public CarView setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
        return this;
    }

    public List<Event> getEvents() {
        return events;
    }

    public CarView setEvents(List<Event> events) {
        this.events = events;
        return this;
    }
}
