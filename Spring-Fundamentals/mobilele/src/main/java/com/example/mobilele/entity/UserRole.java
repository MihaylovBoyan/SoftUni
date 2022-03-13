package com.example.mobilele.entity;

import com.example.mobilele.entity.enums.Role;

import javax.persistence.*;

@Entity
@Table(name = "user_roles")
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private Role name;

    public Long getId() {
        return id;
    }

    public UserRole setId(Long id) {
        this.id = id;
        return this;
    }

    public Role getName() {
        return name;
    }

    public UserRole setName(Role name) {
        this.name = name;
        return this;
    }

    @Override
    public String toString() {
        return "UserRole{" +
                "id=" + id +
                ", name=" + name +
                '}';
    }
}
