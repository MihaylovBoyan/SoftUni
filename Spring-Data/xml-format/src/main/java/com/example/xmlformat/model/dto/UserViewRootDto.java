package com.example.xmlformat.model.dto;

import com.example.xmlformat.model.entity.User;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserViewRootDto {

    @XmlElement(name = "user")
    private List<UserWithProductsDto> products;

    public List<UserWithProductsDto> getProducts() {
        return products;
    }

    public UserViewRootDto setProducts(List<UserWithProductsDto> products) {
        this.products = products;
        return this;
    }
}
