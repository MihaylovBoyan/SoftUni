package com.example.path.model.entity;

import com.example.path.model.entity.enums.levelEnum;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "routes")
public class Route extends BaseEntity{

    private String gpxCoordinates;
    private String description;
    private levelEnum level;
    private String name;
    private User author;
    private String videoUrl;
    private List<Picture> pictures;
    private List<Category> categories;
    private List<Comment> comments;

    @Lob
    public String getGpxCoordinates() {
        return gpxCoordinates;
    }

    public Route setGpxCoordinates(String gpxCoordinates) {
        this.gpxCoordinates = gpxCoordinates;
        return this;
    }

    @Enumerated(EnumType.STRING)
    public levelEnum getLevel() {
        return level;
    }

    public Route setLevel(levelEnum level) {
        this.level = level;
        return this;
    }

    @Column(nullable = false, unique = true)
    public String getName() {
        return name;
    }

    public Route setName(String name) {
        this.name = name;
        return this;
    }

    @ManyToOne
    public User getAuthor() {
        return author;
    }

    public Route setAuthor(User author) {
        this.author = author;
        return this;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public Route setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
        return this;
    }
    @Lob
    public String getDescription() {
        return description;
    }

    public Route setDescription(String description) {
        this.description = description;
        return this;
    }

    @ManyToMany()
    public List<Category> getCategories() {
        return categories;
    }

    public Route setCategories(List<Category> categories) {
        this.categories = categories;
        return this;
    }

    @OneToMany(mappedBy = "route")
    public List<Picture> getPictures() {
        return pictures;
    }

    public Route setPictures(List<Picture> pictures) {
        this.pictures = pictures;
        return this;
    }

    @OneToMany(mappedBy = "route", cascade = CascadeType.ALL)
    public List<Comment> getComments() {
        return comments;
    }

    public Route setComments(List<Comment> comments) {
        this.comments = comments;
        return this;
    }
}
