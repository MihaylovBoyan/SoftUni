package softuni.exam.instagraphlite.models.dto;

import com.google.gson.annotations.Expose;
import softuni.exam.instagraphlite.models.entity.Picture;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserSeedDto {

    @Expose
    private String username;
    @Expose
    private String password;
    @Expose
    private String profilePicture;

    @Size(min = 2, max = 18)
    @NotBlank
    public String getUsername() {
        return username;
    }

    public UserSeedDto setUsername(String username) {
        this.username = username;
        return this;
    }

    @Size(min = 4)
    @NotBlank
    public String getPassword() {
        return password;
    }

    public UserSeedDto setPassword(String password) {
        this.password = password;
        return this;
    }

    @NotBlank
    public String getProfilePicture() {
        return profilePicture;
    }

    public UserSeedDto setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
        return this;
    }
}
