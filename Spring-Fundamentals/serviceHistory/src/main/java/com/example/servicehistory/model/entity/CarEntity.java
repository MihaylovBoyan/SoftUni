package com.example.servicehistory.model.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "cars")
public class CarEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String brand;

    @Column(nullable = false)
    private String model;

    @Column(nullable = false)
    private Integer year;

    @Column(nullable = false)
    private String plateNumber;

    @Lob
    @Column(nullable = false)
    private String imageUrl;

    @Column
    private String shortDescription;

    @OneToMany(mappedBy = "car", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private List<Event> events;

    public Long getId() {
        return id;
    }

    public CarEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public String getBrand() {
        return brand;
    }

    public CarEntity setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public String getModel() {
        return model;
    }

    public CarEntity setModel(String model) {
        this.model = model;
        return this;
    }

    public Integer getYear() {
        return year;
    }

    public CarEntity setYear(Integer year) {
        this.year = year;
        return this;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public CarEntity setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public CarEntity setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public CarEntity setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
        return this;
    }

    public List<Event> getEvents() {
        return events;
    }

    public CarEntity setEvents(List<Event> events) {
        this.events = events;
        return this;
    }
}
