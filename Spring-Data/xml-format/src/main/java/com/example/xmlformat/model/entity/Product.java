package com.example.xmlformat.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.util.Set;

@Entity(name = "products")
public class Product extends BaseEntity {

    private String name;
    private BigDecimal price;
    private User seller;
    private User buyer;
    private Set<Category> categories;


    @Column
    public String getName() {
        return name;
    }

    public Product setName(String name) {
        this.name = name;
        return this;
    }

    @Column
    public BigDecimal getPrice() {
        return price;
    }

    public Product setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    @ManyToOne
    public User getSeller() {
        return seller;
    }

    public Product setSeller(User seller) {
        this.seller = seller;
        return this;
    }

    @ManyToOne
    public User getBuyer() {
        return buyer;
    }

    public Product setBuyer(User buyer) {
        this.buyer = buyer;
        return this;
    }

    @ManyToMany
    public Set<Category> getCategories() {
        return categories;
    }

    public Product setCategories(Set<Category> categories) {
        this.categories = categories;
        return this;
    }
}
