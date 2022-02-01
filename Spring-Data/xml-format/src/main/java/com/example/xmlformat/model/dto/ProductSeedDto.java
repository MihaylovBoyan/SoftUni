package com.example.xmlformat.model.dto;

import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

@XmlRootElement(name = "product")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductSeedDto {

    private String name;
    private BigDecimal price;

    @Size(min = 3)
    public String getName() {
        return name;
    }

    public ProductSeedDto setName(String name) {
        this.name = name;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public ProductSeedDto setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }
}
