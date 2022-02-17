package com.example.workshopp.repository;

import com.example.workshopp.model.entity.Company;
import com.example.workshopp.model.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    boolean existsAllBy();

    Employee findFirstByFirstNameAndLastNameAndAge(String firstName, String lastName, Integer age);
}