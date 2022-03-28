package com.example.judgeversion2.repository;

import com.example.judgeversion2.model.entity.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ExerciseRepository extends JpaRepository<Exercise, Long> {

    @Query("select e.name from Exercise e order by e.name")
    List<String> findAllExercisesByName();

    Optional<Exercise> findByName(String exercise);
}
