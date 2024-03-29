package softuni.exam.instagraphlite.models.dto;

import javax.validation.constraints.NotBlank;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class PictureDto {

    private String path;

    @NotBlank
    public String getPath() {
        return path;
    }

    public PictureDto setPath(String path) {
        this.path = path;
        return this;
    }
}
