package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.CityDto;
import softuni.exam.models.entity.City;
import softuni.exam.repository.CityRepository;
import softuni.exam.service.CityService;
import softuni.exam.service.CountryService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

@Service
public class CityServiceImpl implements CityService {

    private static final String CITIES_FILE_PATH = "src/main/resources/files/json/cities.json";

    private final CityRepository cityRepository;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final CountryService countryService;

    public CityServiceImpl(CityRepository cityRepository, Gson gson, ModelMapper modelMapper, ValidationUtil validationUtil, CountryService countryService) {
        this.cityRepository = cityRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.countryService = countryService;
    }

    @Override
    public boolean areImported() {
        return cityRepository.count() > 0;
    }

    @Override
    public String readCitiesFileContent() throws IOException {
        return Files.readString(Path.of(CITIES_FILE_PATH));
    }

    @Override
    public String importCities() throws IOException {
        StringBuilder sb = new StringBuilder();

        Arrays.stream(gson.fromJson(readCitiesFileContent(), CityDto[].class))
                .filter(cityDto -> {
                    boolean isValid = validationUtil.isValid(cityDto) && !isNotDuplicated(cityDto.getCityName());
                    appendText(sb, cityDto, isValid);
                    return isValid;
                }).map(cityDto -> {
            City city = modelMapper.map(cityDto, City.class);
            city.setCountry(countryService.findById(cityDto.getCountry()));
            return city;
        })
                .forEach(cityRepository::save);

        return sb.toString();
    }

    @Override
    public City findById(Long id) {
        return cityRepository.findById(id).orElse(null);
    }

    private boolean isNotDuplicated(String cityName) {
        return cityRepository.existsByCityName(cityName);
    }

    private void appendText(StringBuilder sb, CityDto cityDto, boolean isValid) {
        if (isValid) {
            sb.append(String.format("Successfully imported city %s - %d%n", cityDto.getCityName(), cityDto.getPopulation()));
        } else {
            sb.append(String.format("Invalid city%n"));
        }

    }
}
