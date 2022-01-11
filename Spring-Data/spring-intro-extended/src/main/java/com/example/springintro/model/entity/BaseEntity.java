package com.example.springintro.model.entity;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private Date deletedOn;

    public Date getDeletedOn() {
        return deletedOn;
    }

    public BaseEntity setDeletedOn(Date deletedOn) {
        this.deletedOn = deletedOn;
        return this;
    }

    public Long getId() {
        return id;
    }

    public BaseEntity setId(Long id) {
        this.id = id;
        return this;
    }
}
