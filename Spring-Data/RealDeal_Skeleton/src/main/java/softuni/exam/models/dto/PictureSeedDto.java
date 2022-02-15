package softuni.exam.models.dto;

import com.google.gson.annotations.Expose;

import javax.validation.constraints.Size;

public class PictureSeedDto {

    @Expose
    private String name;
    @Expose
    private String dateAndTime;
    @Expose
    private Long car;

    @Size(min = 2, max = 20)
    public String getName() {
        return name;
    }

    public PictureSeedDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getDateAndTime() {
        return dateAndTime;
    }

    public PictureSeedDto setDateAndTime(String dateAndTime) {
        this.dateAndTime = dateAndTime;
        return this;
    }

    public Long getCar() {
        return car;
    }

    public PictureSeedDto setCar(Long car) {
        this.car = car;
        return this;
    }
}
