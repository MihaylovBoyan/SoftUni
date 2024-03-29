package softuni.exam.instagraphlite.models.dto;

import com.google.gson.annotations.Expose;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class PictureSeedDto {

    @Expose
    private String path;
    @Expose
    private double size;


    @NotBlank
    public String getPath() {
        return path;
    }

    public PictureSeedDto setPath(String path) {
        this.path = path;
        return this;
    }

    @Min(500)
    @Max(60000)
    public double getSize() {
        return size;
    }

    public PictureSeedDto setSize(double size) {
        this.size = size;
        return this;
    }
}
