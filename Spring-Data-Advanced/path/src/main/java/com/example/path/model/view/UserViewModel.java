package com.example.path.model.view;

import com.example.path.model.entity.enums.levelEnum;

public class UserViewModel {

    private Long id;
    private String fullName;
    private String username;
    private Integer age;
    private levelEnum level;

    public Long getId() {
        return id;
    }

    public UserViewModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public UserViewModel setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserViewModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public UserViewModel setAge(Integer age) {
        this.age = age;
        return this;
    }

    public levelEnum getLevel() {
        return level;
    }

    public UserViewModel setLevel(levelEnum level) {
        this.level = level;
        return this;
    }
}
