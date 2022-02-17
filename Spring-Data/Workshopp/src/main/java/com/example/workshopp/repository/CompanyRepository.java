package com.example.workshopp.repository;

import com.example.workshopp.model.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {

    Company findFirstByName(String name);

    boolean existsByName(String name);

    boolean existsAllBy();
}

