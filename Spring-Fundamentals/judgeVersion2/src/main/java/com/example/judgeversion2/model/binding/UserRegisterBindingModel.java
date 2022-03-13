package com.example.judgeversion2.model.binding;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserRegisterBindingModel {

    private String username;
    private String password;
    private String confirmPassword;
    private String email;
    private String git;

    @Length(min = 2, message = "username length must be at least 2 characters.")
    public String getUsername() {
        return username;
    }

    public UserRegisterBindingModel setUsername(String username) {
        this.username = username;
        return this;
    }
    @Length(min = 3, message = "password length must be at least 3 characters.")

    public String getPassword() {
        return password;
    }

    public UserRegisterBindingModel setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public UserRegisterBindingModel setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }

    @Email(message = "Enter valid email!")
    public String getEmail() {
        return email;
    }

    public UserRegisterBindingModel setEmail(String email) {
        this.email = email;
        return this;
    }

    @Pattern(regexp = "https:\\/\\/github\\.com\\/.+"
    ,message = "Enter valid Git address!")
    public String getGit() {
        return git;
    }

    public UserRegisterBindingModel setGit(String git) {
        this.git = git;
        return this;
    }
}
