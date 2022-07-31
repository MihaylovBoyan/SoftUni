package com.example.path.model.view;

import com.example.path.model.entity.Picture;
import com.example.path.model.entity.enums.levelEnum;

import java.util.Set;

public class RouteDetailsViewModel {

    private Long id;
    private String gpxCoordinates;
    private String description;
    private levelEnum level;
    private String name;
    private String videoUrl;
    private Set<Picture> pictures;

    public Long getId() {
        return id;
    }

    public RouteDetailsViewModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getGpxCoordinates() {
        return gpxCoordinates;
    }

    public RouteDetailsViewModel setGpxCoordinates(String gpxCoordinates) {
        this.gpxCoordinates = gpxCoordinates;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public RouteDetailsViewModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public levelEnum getLevel() {
        return level;
    }

    public RouteDetailsViewModel setLevel(levelEnum level) {
        this.level = level;
        return this;
    }

    public String getName() {
        return name;
    }

    public RouteDetailsViewModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public RouteDetailsViewModel setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
        return this;
    }

    public Set<Picture> getPictures() {
        return pictures;
    }

    public RouteDetailsViewModel setPictures(Set<Picture> pictures) {
        this.pictures = pictures;
        return this;
    }
}
