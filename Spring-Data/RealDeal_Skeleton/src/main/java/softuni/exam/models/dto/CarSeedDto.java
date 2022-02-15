package softuni.exam.models.dto;

import com.google.gson.annotations.Expose;

import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class CarSeedDto {

    @Expose
    private String make;
    @Expose
    private String model;
    @Expose
    private Integer kilometers;
    @Expose
    private String registeredOn;

    @Size(min = 2, max = 20)
    public String getMake() {
        return make;
    }

    public CarSeedDto setMake(String make) {
        this.make = make;
        return this;
    }

    @Size(min = 2, max = 20)
    public String getModel() {
        return model;
    }

    public CarSeedDto setModel(String model) {
        this.model = model;
        return this;
    }

    @Positive
    public Integer getKilometers() {
        return kilometers;
    }

    public CarSeedDto setKilometers(Integer kilometers) {
        this.kilometers = kilometers;
        return this;
    }

    public String getRegisteredOn() {
        return registeredOn;
    }

    public CarSeedDto setRegisteredOn(String registeredOn) {
        this.registeredOn = registeredOn;
        return this;
    }
}
