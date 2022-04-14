package softuni.exam.models.dto;

import softuni.exam.models.enums.RatingEnum;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class SellerDto {

    @XmlElement(name = "first-name")
    private String firstName;
    @XmlElement(name = "last-name")
    private String lastName;
    @XmlElement
    private String email;
    @XmlElement
    private RatingEnum rating;
    @XmlElement
    private String town;

    @Size(min = 2 , max = 20)
    public String getFirstName() {
        return firstName;
    }

    public SellerDto setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    @Size(min = 2 , max = 20)
    public String getLastName() {
        return lastName;
    }

    public SellerDto setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    @Email
    public String getEmail() {
        return email;
    }

    public SellerDto setEmail(String email) {
        this.email = email;
        return this;
    }

    @NotNull
    public RatingEnum getRating() {
        return rating;
    }

    public SellerDto setRating(RatingEnum rating) {
        this.rating = rating;
        return this;
    }

    @NotBlank
    public String getTown() {
        return town;
    }

    public SellerDto setTown(String town) {
        this.town = town;
        return this;
    }
}
