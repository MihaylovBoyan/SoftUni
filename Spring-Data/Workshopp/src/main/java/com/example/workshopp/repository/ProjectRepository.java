package com.example.workshopp.repository;

import com.example.workshopp.model.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {

    boolean existsAllBy();

    Project findFirstByNameAndCompanyName(String name, String companyName);
}
