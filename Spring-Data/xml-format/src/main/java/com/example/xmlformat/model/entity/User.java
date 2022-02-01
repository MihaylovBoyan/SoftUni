package com.example.xmlformat.model.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity(name = "users")
public class User extends BaseEntity {

    private String firstName;
    private String lastName;
    private Set<User> friends;
    private Set<Product> soldProducts;

    public String getFirstName() {
        return firstName;
    }

    public User setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public User setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    @ManyToMany
    public Set<User> getFriends() {
        return friends;
    }

    public User setFriends(Set<User> friends) {
        this.friends = friends;
        return this;
    }

    @OneToMany(fetch = FetchType.EAGER)
    public Set<Product> getSoldProducts() {
        return soldProducts;
    }

    public User setSoldProducts(Set<Product> soldProducts) {
        this.soldProducts = soldProducts;
        return this;
    }
}
