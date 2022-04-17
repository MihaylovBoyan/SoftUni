package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.CountryDto;
import softuni.exam.models.entity.Country;
import softuni.exam.repository.CountryRepository;
import softuni.exam.service.CountryService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

@Service
public class CountryServiceImpl implements CountryService {

    private static final String COUNTRY_FILE_PATH = "src/main/resources/files/json/countries.json";

    private final CountryRepository countryRepository;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    public CountryServiceImpl(CountryRepository countryRepository, Gson gson, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.countryRepository = countryRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return countryRepository.count() > 0;
    }

    @Override
    public String readCountriesFromFile() throws IOException {
        return Files.readString(Path.of(COUNTRY_FILE_PATH));
    }

    @Override
    public String importCountries() throws IOException {

        StringBuilder sb = new StringBuilder();

        Arrays.stream(gson.fromJson(readCountriesFromFile(), CountryDto[].class))
                .filter(countryDto -> {
                    boolean isValid = validationUtil.isValid(countryDto) && !isNotDuplicated(countryDto.getCountryName());
                    appendText(sb, countryDto, isValid);
                    return isValid;
                }).map(countryDto -> modelMapper.map(countryDto, Country.class))
                .forEach(countryRepository::save);

        return sb.toString();
    }

    @Override
    public Country findById(Long id) {
        return countryRepository.findById(id).orElse(null);
    }

    private boolean isNotDuplicated(String countryName) {
        return countryRepository.existsByCountryName(countryName);
    }

    private void appendText(StringBuilder sb, CountryDto countryDto, boolean isValid) {
        if (isValid) {
            sb.append(String.format("Successfully imported country %s - %s%n", countryDto.getCountryName(), countryDto.getCurrency()));
        } else {
            sb.append(String.format("Invalid country%n"));
        }
    }
}
