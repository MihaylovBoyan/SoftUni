package com.example.xmlformat.model.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

@XmlRootElement(name = "product")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductWithBuyer {

    @XmlElement(name = "name")
    private String name;

    @XmlElement(name = "price")
    private BigDecimal price;

    @XmlElement(name = "buyer-first-name")
    private String buyerFirstName;

    @XmlElement(name = "buyer-last-name")
    private String buyerLastName;

    public String getName() {
        return name;
    }

    public ProductWithBuyer() {
    }

    public ProductWithBuyer setName(String name) {
        this.name = name;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public ProductWithBuyer setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public String getBuyerFirstName() {
        return buyerFirstName;
    }

    public ProductWithBuyer setBuyerFirstName(String buyerFirstName) {
        this.buyerFirstName = buyerFirstName;
        return this;
    }

    public String getBuyerLastName() {
        return buyerLastName;
    }

    public ProductWithBuyer setBuyerLastName(String buyerLastName) {
        this.buyerLastName = buyerLastName;
        return this;
    }
}
