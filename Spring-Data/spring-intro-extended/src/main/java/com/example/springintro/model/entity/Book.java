package com.example.springintro.model.entity;

import com.example.springintro.model.entity.enums.AgeRestriction;
import com.example.springintro.model.entity.enums.EditionType;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "books")
public class Book extends BaseEntity {

    @Column(length = 60, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Enumerated
    private EditionType editionType;

    private BigDecimal price;

    private Integer copies;

    @Column(name = "release_date")
    private LocalDate releaseDate;

    @Enumerated
    private AgeRestriction ageRestriction;

    @ManyToOne
    private Author author;

    @ManyToMany
    private Set<Category> categories;

    public Book(){

    }

    public Book(EditionType editionType, LocalDate releaseDate,
                Integer copies, BigDecimal price, AgeRestriction ageRestriction, String title, Author author, Set<Category> categories) {
        this.editionType = editionType;
        this.releaseDate = releaseDate;
        this.copies = copies;
        this.price = price;
        this.ageRestriction = ageRestriction;
        this.title = title;
        this.author = author;
        this.categories = categories;
    }


    public Author getAuthor() {
        return author;
    }

    public Book setAuthor(Author author) {
        this.author = author;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Book setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Book setDescription(String description) {
        this.description = description;
        return this;
    }

    public EditionType getEditionType() {
        return editionType;
    }

    public Book setEditionType(EditionType editionType) {
        this.editionType = editionType;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Book setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public Integer getCopies() {
        return copies;
    }

    public Book setCopies(Integer copies) {
        this.copies = copies;
        return this;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public Book setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
        return this;
    }

    public AgeRestriction getAgeRestriction() {
        return ageRestriction;
    }

    public Book setAgeRestriction(AgeRestriction ageRestriction) {
        this.ageRestriction = ageRestriction;
        return this;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public Book setCategories(Set<Category> categories) {
        this.categories = categories;
        return this;
    }
}
