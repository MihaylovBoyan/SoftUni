package softuni.exam.models.dto;

import com.google.gson.annotations.Expose;

import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Date;

public class CarDto {

    @Expose
    private String make;
    @Expose
    private String model;
    @Expose
    private int kilometers;
    @Expose
    private String registeredOn;

    public CarDto(){

    }

    @Size(min = 2, max = 20)
    public String getMake() {
        return make;
    }

    public CarDto setMake(String make) {
        this.make = make;
        return this;
    }

    @Size(min = 2, max = 20)
    public String getModel() {
        return model;
    }

    public CarDto setModel(String model) {
        this.model = model;
        return this;
    }

    @PositiveOrZero
    public int getKilometers() {
        return kilometers;
    }

    public CarDto setKilometers(int kilometers) {
        this.kilometers = kilometers;
        return this;
    }


    public String getRegisteredOn() {
        return registeredOn;
    }

    public CarDto setRegisteredOn(String registeredOn) {
        this.registeredOn = registeredOn;
        return this;
    }
}
