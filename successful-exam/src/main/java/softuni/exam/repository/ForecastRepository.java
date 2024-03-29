package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.exam.models.entity.City;
import softuni.exam.models.entity.Forecast;

import java.util.List;

@Repository
public interface ForecastRepository extends JpaRepository<Forecast, Long> {


    @Query("SELECT f FROM Forecast f where f.daysOfWeek = 'SUNDAY' and f.city.population < 150000 ORDER BY f.maxTemperature DESC, f.id ASC")
    List<Forecast> exportSundayForecast();

}
