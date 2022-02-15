package softuni.exam.models.dto;

import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.math.BigDecimal;

@XmlAccessorType(XmlAccessType.FIELD)
public class OffersSeedDto {

    private String description;

    private BigDecimal price;

    @XmlElement(name = "added-on")
    private String addedOn;

    @XmlElement(name = "has-gold-status")
    private Boolean hasGoldStatus;

    @XmlElement(name = "car")
    private CardIdDto car;

    @XmlElement(name = "seller")
    private SellerIdDto seller;

    @Size(min = 5)
    public String getDescription() {
        return description;
    }

    public OffersSeedDto setDescription(String description) {
        this.description = description;
        return this;
    }

    @Positive
    public BigDecimal getPrice() {
        return price;
    }

    public OffersSeedDto setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public String getAddedOn() {
        return addedOn;
    }

    public OffersSeedDto setAddedOn(String addedOn) {
        this.addedOn = addedOn;
        return this;
    }

    public Boolean getHasGoldStatus() {
        return hasGoldStatus;
    }

    public OffersSeedDto setHasGoldStatus(Boolean hasGoldStatus) {
        this.hasGoldStatus = hasGoldStatus;
        return this;
    }

    public CardIdDto getCar() {
        return car;
    }

    public OffersSeedDto setCar(CardIdDto car) {
        this.car = car;
        return this;
    }

    public SellerIdDto getSeller() {
        return seller;
    }

    public OffersSeedDto setSeller(SellerIdDto seller) {
        this.seller = seller;
        return this;
    }
}
