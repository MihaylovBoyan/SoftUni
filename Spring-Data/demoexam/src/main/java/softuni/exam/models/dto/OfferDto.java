package softuni.exam.models.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.math.BigDecimal;

@XmlAccessorType(XmlAccessType.FIELD)
public class OfferDto {

    @XmlElement
    private String description;
    @XmlElement
    private BigDecimal price;
    @XmlElement(name = "added-on")
    private String addedOn;
    @XmlElement(name = "has-gold-status")
    private boolean hasGoldStatus;
    @XmlElement(name = "car")
    private CarIdDto id;
    @XmlElement(name = "seller")
    private SellerIdDto sellerId;

    @Size(min = 5)
    public String getDescription() {
        return description;
    }

    public OfferDto setDescription(String description) {
        this.description = description;
        return this;
    }

    @Positive
    public BigDecimal getPrice() {
        return price;
    }

    public OfferDto setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    @NotNull
    public String getAddedOn() {
        return addedOn;
    }

    public OfferDto setAddedOn(String addedOn) {
        this.addedOn = addedOn;
        return this;
    }

    @NotNull
    public boolean isHasGoldStatus() {
        return hasGoldStatus;
    }

    public OfferDto setHasGoldStatus(boolean hasGoldStatus) {
        this.hasGoldStatus = hasGoldStatus;
        return this;
    }

    @NotNull
    public CarIdDto getId() {
        return id;
    }

    public OfferDto setId(CarIdDto id) {
        this.id = id;
        return this;
    }

    public SellerIdDto getSellerId() {
        return sellerId;
    }

    public OfferDto setSellerId(SellerIdDto sellerId) {
        this.sellerId = sellerId;
        return this;
    }
}
