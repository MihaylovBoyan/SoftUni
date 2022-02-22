package softuni.exam.instagraphlite.models.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class PostDto {

    private String caption;
    private UserDto user;
    private PictureDto picture;

    @Size(min = 21)
    @NotBlank
    public String getCaption() {
        return caption;
    }

    public PostDto setCaption(String caption) {
        this.caption = caption;
        return this;
    }

    @NotNull
    public UserDto getUser() {
        return user;
    }

    public PostDto setUser(UserDto user) {
        this.user = user;
        return this;
    }

    @NotNull
    public PictureDto getPicture() {
        return picture;
    }

    public PostDto setPicture(PictureDto picture) {
        this.picture = picture;
        return this;
    }
}
