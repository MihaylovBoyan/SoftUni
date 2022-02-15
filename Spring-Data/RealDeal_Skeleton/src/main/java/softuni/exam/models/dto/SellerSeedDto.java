package softuni.exam.models.dto;

import softuni.exam.models.entity.enums.Rating;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class SellerSeedDto {

    @XmlElement(name = "first-name")
    private String firstName;
    @XmlElement(name = "last-name")
    private String lastName;
    @XmlElement(name = "email")
    private String email;
    @XmlElement(name = "rating")
    private Rating rating;
    @XmlElement(name = "town")
    private String town;

    @Size(min = 2, max = 20)
    public String getFirstName() {
        return firstName;
    }

    public SellerSeedDto setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    @Size(min = 2, max = 20)
    public String getLastName() {
        return lastName;
    }

    public SellerSeedDto setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    @Email
    public String getEmail() {
        return email;
    }

    public SellerSeedDto setEmail(String email) {
        this.email = email;
        return this;
    }

    @NotNull
    public Rating getRating() {
        return rating;
    }

    public SellerSeedDto setRating(Rating rating) {
        this.rating = rating;
        return this;
    }

    @NotBlank
    public String getTown() {
        return town;
    }

    public SellerSeedDto setTown(String town) {
        this.town = town;
        return this;
    }
}
