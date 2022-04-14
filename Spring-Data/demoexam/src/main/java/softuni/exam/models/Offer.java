package softuni.exam.models;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "offers")
public class Offer extends BaseEntity{

    private BigDecimal price;
    private String description;
    private boolean hasGoldStatus;
    private LocalDateTime addedOn;
    private Car car;
    private Seller seller;
    private List<Picture> pictures;

    @Column
    public BigDecimal getPrice() {
        return price;
    }

    public Offer setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    @Length(min = 5)
    @Column(columnDefinition = "TEXT")
    public String getDescription() {
        return description;
    }

    public Offer setDescription(String description) {
        this.description = description;
        return this;
    }

    @Column
    public boolean isHasGoldStatus() {
        return hasGoldStatus;
    }

    public Offer setHasGoldStatus(boolean hasGoldStatus) {
        this.hasGoldStatus = hasGoldStatus;
        return this;
    }

    @Column
    public LocalDateTime getAddedOn() {
        return addedOn;
    }

    public Offer setAddedOn(LocalDateTime addedOn) {
        this.addedOn = addedOn;
        return this;
    }

    @ManyToOne
    public Car getCar() {
        return car;
    }

    public Offer setCar(Car car) {
        this.car = car;
        return this;
    }

    @ManyToOne
    public Seller getSeller() {
        return seller;
    }

    public Offer setSeller(Seller seller) {
        this.seller = seller;
        return this;
    }

    @ManyToMany
    public List<Picture> getPictures() {
        return pictures;
    }

    public Offer setPictures(List<Picture> pictures) {
        this.pictures = pictures;
        return this;
    }
}
