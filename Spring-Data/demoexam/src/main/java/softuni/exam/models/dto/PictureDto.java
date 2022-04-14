package softuni.exam.models.dto;

import com.google.gson.annotations.Expose;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

public class PictureDto {

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

    public PictureDto setName(String name) {
        this.name = name;
        return this;
    }

    @NotNull
    public String getDateAndTime() {
        return dateAndTime;
    }

    public PictureDto setDateAndTime(String dateAndTime) {
        this.dateAndTime = dateAndTime;
        return this;
    }

    @NotNull
    public Long getCar() {
        return car;
    }

    public PictureDto setCar(Long car) {
        this.car = car;
        return this;
    }
}
