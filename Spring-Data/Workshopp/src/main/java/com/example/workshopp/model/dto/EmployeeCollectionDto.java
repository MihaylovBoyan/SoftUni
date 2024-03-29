package com.example.workshopp.model.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "employees")
@XmlAccessorType(XmlAccessType.FIELD)
public class EmployeeCollectionDto {

    @XmlElement(name = "employee")
    private List<EmployeeDto> employees;


    public List<EmployeeDto> getEmployees() {
        return employees;
    }

    public EmployeeCollectionDto setEmployees(List<EmployeeDto> employees) {
        this.employees = employees;
        return this;
    }
}
