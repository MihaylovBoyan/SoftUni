package softuni.exam.models.dto;

import org.springframework.lang.Nullable;
import softuni.exam.models.entity.City;
import softuni.exam.models.entity.enums.DaysOfWeekEnum;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.sql.Time;

@XmlAccessorType(XmlAccessType.FIELD)
public class ForeCastDto {

    @XmlElement(name = "day_of_week")
    private DaysOfWeekEnum dayOfWeek;
    @XmlElement(name = "max_temperature")
    private double maxTemperature;
    @XmlElement(name = "min_temperature")
    private double minTemperature;
    @XmlElement(name = "sunrise")
    private String sunrise;
    @XmlElement(name = "sunset")
    private String sunset;
    @XmlElement(name = "city")
    private Long city;

    @NotNull
    public DaysOfWeekEnum getDayOfWeek() {
        return dayOfWeek;
    }

    public ForeCastDto setDayOfWeek(DaysOfWeekEnum dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
        return this;
    }

    @Min(-20)
    @Max(60)
    public double getMaxTemperature() {
        return maxTemperature;
    }

    public ForeCastDto setMaxTemperature(double maxTemperature) {
        this.maxTemperature = maxTemperature;
        return this;
    }

    @Min(-50)
    @Max(40)
    public double getMinTemperature() {
        return minTemperature;
    }

    public ForeCastDto setMinTemperature(double minTemperature) {
        this.minTemperature = minTemperature;
        return this;
    }

    @NotNull
    public String getSunrise() {
        return sunrise;
    }

    public ForeCastDto setSunrise(String sunrise) {
        this.sunrise = sunrise;
        return this;
    }

    @NotNull
    public String getSunset() {
        return sunset;
    }

    public ForeCastDto setSunset(String sunset) {
        this.sunset = sunset;
        return this;
    }

    @NotNull
    public Long getCity() {
        return city;
    }

    public ForeCastDto setCity(Long city) {
        this.city = city;
        return this;
    }
}
