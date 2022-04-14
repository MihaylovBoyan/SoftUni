package softuni.exam.models;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "cars")
public class Car extends BaseEntity {

    private String make;
    private String model;
    private int kilometers;
    private LocalDate registeredOn;
    private Set<Picture> pictures;

    @Column(length = 20)
    public String getMake() {
        return make;
    }

    public Car setMake(String make) {
        this.make = make;
        return this;
    }

    @Column(length = 20)
    public String getModel() {
        return model;
    }

    public Car setModel(String model) {
        this.model = model;
        return this;
    }

    @Column()
    public int getKilometers() {
        return kilometers;
    }

    public Car setKilometers(int kilometers) {
        this.kilometers = kilometers;
        return this;
    }

    @Column
    public LocalDate getRegisteredOn() {
        return registeredOn;
    }

    public Car setRegisteredOn(LocalDate registeredOn) {
        this.registeredOn = registeredOn;
        return this;
    }

    @OneToMany(mappedBy = "car", fetch = FetchType.EAGER)
    public Set<Picture> getPictures() {
        return pictures;
    }

    public Car setPictures(Set<Picture> pictures) {
        this.pictures = pictures;
        return this;
    }
}