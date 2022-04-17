package softuni.exam.models.entity;

import softuni.exam.models.entity.enums.DaysOfWeekEnum;

import javax.persistence.*;
import java.sql.Time;
import java.time.LocalDateTime;

@Entity
@Table(name = "forecasts")
public class Forecast extends BaseEntity{

    private DaysOfWeekEnum dayOfWeek;
    private double maxTemperature;
    private double minTemperature;
    private Time sunrise;
    private Time sunset;
    private City city;

    @Enumerated(EnumType.STRING)
    public DaysOfWeekEnum getDaysOfWeek() {
        return dayOfWeek;
    }

    public Forecast setDaysOfWeek(DaysOfWeekEnum daysOfWeek) {
        this.dayOfWeek = daysOfWeek;
        return this;
    }

    @Column(nullable = false)
    public double getMaxTemperature() {
        return maxTemperature;
    }

    public Forecast setMaxTemperature(double maxTemperature) {
        this.maxTemperature = maxTemperature;
        return this;
    }

    @Column(nullable = false)
    public double getMinTemperature() {
        return minTemperature;
    }

    public Forecast setMinTemperature(double minTemperature) {
        this.minTemperature = minTemperature;
        return this;
    }

    @Column(nullable = false)
    public Time getSunrise() {
        return sunrise;
    }

    public Forecast setSunrise(Time sunrise) {
        this.sunrise = sunrise;
        return this;
    }

    @Column(nullable = false)
    public Time getSunset() {
        return sunset;
    }

    public Forecast setSunset(Time sunset) {
        this.sunset = sunset;
        return this;
    }

    @ManyToOne
    public City getCity() {
        return city;
    }

    public Forecast setCity(City city) {
        this.city = city;
        return this;
    }
}
