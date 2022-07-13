package com.example.andreys.model.binding;

import com.example.andreys.model.entity.enums.CategoryNameEnum;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

public class ItemAddBindingModel {

    private String name;
    private String description;
    private CategoryNameEnum category;
    private String gender;
    private BigDecimal price;

    @Size(min = 2, message = "At least 2 characters please")
    public String getName() {
        return name;
    }

    public ItemAddBindingModel setName(String name) {
        this.name = name;
        return this;
    }
    @Size(min = 3, message = "At least 3 characters please")
    public String getDescription() {
        return description;
    }

    public ItemAddBindingModel setDescription(String description) {
        this.description = description;
        return this;
    }

    @NotNull(message = "Enter valid category name!")
    public CategoryNameEnum getCategory() {
        return category;
    }

    public ItemAddBindingModel setCategory(CategoryNameEnum category) {
        this.category = category;
        return this;
    }

    @Length(min = 2, message = "Enter valid gender!")
    public String getGender() {
        return gender;
    }

    public ItemAddBindingModel setGender(String gender) {
        this.gender = gender;
        return this;
    }

    @DecimalMin(value = "0",message = "enter valid price")
    public BigDecimal getPrice() {
        return price;
    }

    public ItemAddBindingModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }
}
