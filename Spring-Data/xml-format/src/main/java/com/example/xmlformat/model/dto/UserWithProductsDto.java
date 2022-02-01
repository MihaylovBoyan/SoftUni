package com.example.xmlformat.model.dto;

import com.example.xmlformat.model.entity.Product;

import javax.xml.bind.annotation.*;
import java.util.Set;

@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserWithProductsDto {

    @XmlAttribute(name = "first-name")
    private String firstName;

    @XmlAttribute(name = "last-name")
    private String lastName;

    @XmlElement(name = "product")
    @XmlElementWrapper(name = "sold-products")
    private Set<ProductWithBuyer> soldProducts;

    public String getFirstName() {
        return firstName;
    }

    public UserWithProductsDto setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserWithProductsDto setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Set<ProductWithBuyer> getSoldProducts() {
        return soldProducts;
    }

    public UserWithProductsDto setSoldProducts(Set<ProductWithBuyer> soldProducts) {
        this.soldProducts = soldProducts;
        return this;
    }
}
