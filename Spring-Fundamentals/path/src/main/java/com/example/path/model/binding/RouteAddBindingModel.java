package com.example.path.model.binding;

import com.example.path.model.entity.Category;
import com.example.path.model.entity.Picture;
import com.example.path.model.entity.User;
import com.example.path.model.entity.enums.CategoryNameEnum;
import com.example.path.model.entity.enums.levelEnum;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

public class RouteAddBindingModel {

    private String name;
    private String description;
    private MultipartFile gpxCoordinates;
    private levelEnum level;
    private String videoUrl;
    private Set<CategoryNameEnum> categories;

    @Size(min = 3, max = 20, message = "routes name must be between 3 and 20 characters")
    public String getName() {
        return name;
    }

    public RouteAddBindingModel setName(String name) {
        this.name = name;
        return this;
    }

    @Size(min = 3)
    public String getDescription() {
        return description;
    }

    public RouteAddBindingModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public MultipartFile getGpxCoordinates() {
        return gpxCoordinates;
    }

    public RouteAddBindingModel setGpxCoordinates(MultipartFile gpxCoordinates) {
        this.gpxCoordinates = gpxCoordinates;
        return this;
    }

    @NotNull
    public levelEnum getLevel() {
        return level;
    }

    public RouteAddBindingModel setLevel(levelEnum level) {
        this.level = level;
        return this;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public RouteAddBindingModel setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
        return this;
    }

    public Set<CategoryNameEnum> getCategories() {
        return categories;
    }

    public RouteAddBindingModel setCategories(Set<CategoryNameEnum> categories) {
        this.categories = categories;
        return this;
    }
}
