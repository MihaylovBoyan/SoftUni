package com.example.springdatademo.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
public class User extends BaseEntity {

    @Column(unique = true)
    private String username;

    private int age;

    @OneToMany(mappedBy = "user")
    private Set<Account> accounts;

    public String getUsername() {
        return username;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    public int getAge() {
        return age;
    }

    public User setAge(int age) {
        this.age = age;
        return this;
    }

    public Set<Account> getAccounts() {
        return accounts;
    }

    public User setAccounts(Set<Account> accounts) {
        this.accounts = accounts;
        return this;
    }
}
