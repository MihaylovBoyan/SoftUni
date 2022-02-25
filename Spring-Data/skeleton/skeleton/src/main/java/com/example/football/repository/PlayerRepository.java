package com.example.football.repository;


import com.example.football.models.entity.Player;
import com.example.football.models.entity.enums.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

    boolean existsByEmail(String email);

    @Query("select p from Player p where p.birthDate > :date and p.birthDate < :secDate " +
            "order by p.statId.shooting desc, p.statId.passing desc, p.statId.endurance desc, p.lastName")
    List<Player> findAllByBirthDateAfterAndBirthDateBeforeOrderBy(LocalDate date, LocalDate secDate);

}
