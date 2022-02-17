package com.example.workshopp.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "projects")
public class Project extends BaseEntity{

    private String name;
    private String description;
    private Boolean isFinished;
    private BigDecimal payment;
    private LocalDate startDate;
    private Company company;

    @Column(nullable = false)
    public String getName() {
        return name;
    }

    public Project setName(String name) {
        this.name = name;
        return this;
    }

    @Column(columnDefinition = "TEXT", nullable = false)
    public String getDescription() {
        return description;
    }

    public Project setDescription(String description) {
        this.description = description;
        return this;
    }

    @Column(name = "is_finished")
    public Boolean getFinished() {
        return isFinished;
    }

    public Project setFinished(Boolean finished) {
        isFinished = finished;
        return this;
    }

    @Column(nullable = false)
    public BigDecimal getPayment() {
        return payment;
    }

    public Project setPayment(BigDecimal payment) {
        this.payment = payment;
        return this;
    }

    @Column(columnDefinition = "DATE")
    public LocalDate getStartDate() {
        return startDate;
    }

    public Project setStartDate(LocalDate startDate) {
        this.startDate = startDate;
        return this;
    }

    @ManyToOne
    public Company getCompany() {
        return company;
    }

    public Project setCompany(Company company) {
        this.company = company;
        return this;
    }
}
