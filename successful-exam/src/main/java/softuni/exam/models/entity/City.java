package softuni.exam.models.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "cities")
public class City extends BaseEntity{

    private String cityName;
    private String description;
    private int population;
    private Country country;
    private Set<Forecast> forecasts;

    @Column(unique = true, nullable = false)
    public String getCityName() {
        return cityName;
    }

    public City setCityName(String cityName) {
        this.cityName = cityName;
        return this;
    }

    @Column(columnDefinition = "TEXT")
    public String getDescription() {
        return description;
    }

    public City setDescription(String description) {
        this.description = description;
        return this;
    }

    @Column(nullable = false)
    public int getPopulation() {
        return population;
    }

    public City setPopulation(int population) {
        this.population = population;
        return this;
    }

    @ManyToOne
    public Country getCountry() {
        return country;
    }

    public City setCountry(Country country) {
        this.country = country;
        return this;
    }

    @OneToMany(mappedBy = "city")
    public Set<Forecast> getForecasts() {
        return forecasts;
    }

    public City setForecasts(Set<Forecast> forecasts) {
        this.forecasts = forecasts;
        return this;
    }
}
