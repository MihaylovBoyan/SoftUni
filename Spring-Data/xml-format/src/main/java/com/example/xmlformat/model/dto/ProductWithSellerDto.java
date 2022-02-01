package com.example.xmlformat.model.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

@XmlRootElement(name = "product")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductWithSellerDto {

    @XmlAttribute(name = "name")
    private String name;

    @XmlAttribute(name = "price")
    private BigDecimal price;

    @XmlAttribute(name = "seller")
    private String seller;

    public String getName() {
        return name;
    }

    public ProductWithSellerDto setName(String name) {
        this.name = name;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public ProductWithSellerDto setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public String getSeller() {
        return seller;
    }

    public ProductWithSellerDto setSeller(String seller) {
        this.seller = seller;
        return this;
    }
}
