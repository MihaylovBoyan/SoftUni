package softuni.exam.models.dto;

import com.google.gson.annotations.Expose;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CountryDto {

    @Expose
    private String countryName;
    @Expose
    private String currency;

    @NotNull
    @Size(min = 2, max = 60)
    public String getCountryName() {
        return countryName;
    }

    public CountryDto setCountryName(String countryName) {
        this.countryName = countryName;
        return this;
    }

    @NotNull
    @Size(min = 2, max = 60)
    public String getCurrency() {
        return currency;
    }

    public CountryDto setCurrency(String currency) {
        this.currency = currency;
        return this;
    }
}
