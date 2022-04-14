package softuni.exam.models;

import org.hibernate.validator.constraints.Length;
import softuni.exam.models.enums.RatingEnum;

import javax.persistence.*;

@Entity
@Table(name = "sellers")
public class Seller extends BaseEntity{

    private String firstName;
    private String lastName;
    private String email;
    private RatingEnum rating;
    private String town;

    @Length(min = 2, max = 20)
    public String getFirstName() {
        return firstName;
    }

    public Seller setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    @Length(min = 2, max = 20)
    public String getLastName() {
        return lastName;
    }

    public Seller setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    @Column(unique = true, nullable = false)
    public String getEmail() {
        return email;
    }

    public Seller setEmail(String email) {
        this.email = email;
        return this;
    }

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    public RatingEnum getRating() {
        return rating;
    }

    public Seller setRating(RatingEnum rating) {
        this.rating = rating;
        return this;
    }

    @Column(nullable = false)
    public String getTown() {
        return town;
    }

    public Seller setTown(String town) {
        this.town = town;
        return this;
    }
}
