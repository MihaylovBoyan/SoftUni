package com.example.workshopp.model.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.math.BigDecimal;
import java.util.Date;

@XmlAccessorType(XmlAccessType.FIELD)
public class ProjectDto {

    private String name;
    private String description;
    @XmlElement(name = "start-date")
    private Date startDate;
    @XmlElement(name = "is-finished")
    private boolean isFinished;
    private BigDecimal payment;
    private CompanyDto company;

    public String getName() {
        return name;
    }

    public ProjectDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ProjectDto setDescription(String description) {
        this.description = description;
        return this;
    }

    public Date getStartDate() {
        return startDate;
    }

    public ProjectDto setStartDate(Date startDate) {
        this.startDate = startDate;
        return this;
    }

    public boolean isFinished() {
        return isFinished;
    }

    public ProjectDto setFinished(boolean finished) {
        isFinished = finished;
        return this;
    }

    public BigDecimal getPayment() {
        return payment;
    }

    public ProjectDto setPayment(BigDecimal payment) {
        this.payment = payment;
        return this;
    }

    public CompanyDto getCompany() {
        return company;
    }

    public ProjectDto setCompany(CompanyDto company) {
        this.company = company;
        return this;
    }
}
