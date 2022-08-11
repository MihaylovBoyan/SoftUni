package com.example.mobi.repository;

import com.example.mobi.model.entity.ModelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ModelRepository extends JpaRepository<ModelEntity, Long> {

    Optional<ModelEntity> findByName(String name);

    @Query("SELECT m.name FROM ModelEntity m")
    List<String> findAllNames();
}
