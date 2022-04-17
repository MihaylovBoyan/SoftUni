package softuni.exam.models.dto;

import com.google.gson.annotations.Expose;
import softuni.exam.models.entity.Country;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CityDto {

    @Expose
    private String cityName;
    @Expose
    private String description;
    @Expose
    private int population;
    @Expose
    private Long country;

    @NotNull
    @Size(min = 2, max = 60)
    public String getCityName() {
        return cityName;
    }

    public CityDto setCityName(String cityName) {
        this.cityName = cityName;
        return this;
    }


    @Size(min = 2)
    public String getDescription() {
        return description;
    }

    public CityDto setDescription(String description) {
        this.description = description;
        return this;
    }

    @NotNull
    @Min(500)
    public int getPopulation() {
        return population;
    }

    public CityDto setPopulation(int population) {
        this.population = population;
        return this;
    }

    @NotNull
    public Long getCountry() {
        return country;
    }

    public CityDto setCountry(Long country) {
        this.country = country;
        return this;
    }
}
