package com.example.workshopp.model.dto;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "companies")
@XmlAccessorType(XmlAccessType.FIELD)
public class CompanyCollectionDto {

    @XmlElement(name = "company")
    private List<CompanyDto> companies;

    public List<CompanyDto> getCompanies() {
        return companies;
    }

    public CompanyCollectionDto setCompanies(List<CompanyDto> companies) {
        this.companies = companies;
        return this;
    }
}
