package com.example.path.model.service;

import com.example.path.model.entity.Category;
import com.example.path.model.entity.Picture;
import com.example.path.model.entity.User;
import com.example.path.model.entity.enums.CategoryNameEnum;
import com.example.path.model.entity.enums.levelEnum;

import java.util.Set;

public class RouteServiceModel {

    private Long id;
    private String gpxCoordinates;
    private String description;
    private levelEnum level;
    private String name;
    private User author;
    private String videoUrl;
    private Set<Picture> pictures;
    private Set<CategoryNameEnum> categories;

    public Long getId() {
        return id;
    }

    public RouteServiceModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getGpxCoordinates() {
        return gpxCoordinates;
    }

    public RouteServiceModel setGpxCoordinates(String gpxCoordinates) {
        this.gpxCoordinates = gpxCoordinates;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public RouteServiceModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public levelEnum getLevel() {
        return level;
    }

    public RouteServiceModel setLevel(levelEnum level) {
        this.level = level;
        return this;
    }

    public String getName() {
        return name;
    }

    public RouteServiceModel setName(String name) {
        this.name = name;
        return this;
    }

    public User getAuthor() {
        return author;
    }

    public RouteServiceModel setAuthor(User author) {
        this.author = author;
        return this;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public RouteServiceModel setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
        return this;
    }

    public Set<Picture> getPictures() {
        return pictures;
    }

    public RouteServiceModel setPictures(Set<Picture> pictures) {
        this.pictures = pictures;
        return this;
    }

    public Set<CategoryNameEnum> getCategories() {
        return categories;
    }

    public RouteServiceModel setCategories(Set<CategoryNameEnum> categories) {
        this.categories = categories;
        return this;
    }
}
