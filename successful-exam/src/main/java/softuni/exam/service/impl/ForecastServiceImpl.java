package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.ForeCastDto;
import softuni.exam.models.dto.ForecastsRootDto;
import softuni.exam.models.entity.City;
import softuni.exam.models.entity.Forecast;
import softuni.exam.repository.ForecastRepository;
import softuni.exam.service.CityService;
import softuni.exam.service.ForecastService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Service
public class ForecastServiceImpl implements ForecastService {

    private static final String FORECASTS_FILE_PATH = "src/main/resources/files/xml/forecasts.xml";

    private final ForecastRepository forecastRepository;
    private final XmlParser xmlParser;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final CityService cityService;

    public ForecastServiceImpl(ForecastRepository forecastRepository, XmlParser xmlParser, ModelMapper modelMapper, ValidationUtil validationUtil, CityService cityService) {
        this.forecastRepository = forecastRepository;
        this.xmlParser = xmlParser;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.cityService = cityService;
    }

    @Override
    public boolean areImported() {
        return forecastRepository.count() > 0;
    }

    @Override
    public String readForecastsFromFile() throws IOException {
        return Files.readString(Path.of(FORECASTS_FILE_PATH));
    }

    @Override
    public String importForecasts() throws IOException, JAXBException {

        StringBuilder sb = new StringBuilder();


        xmlParser.fromFile(FORECASTS_FILE_PATH, ForecastsRootDto.class)
                .getForecasts()
                .stream()
                .filter(foreCastDto -> {
                    boolean isValid = validationUtil.isValid(foreCastDto);
                    appendText(sb, foreCastDto, isValid);
                    return isValid;
                })
                .map(foreCastDto -> {

                    Forecast forecast = modelMapper.map(foreCastDto, Forecast.class);
                    forecast.setCity(cityService.findById(foreCastDto.getCity()));

                    return forecast;
                }).forEach(forecastRepository::save);


        return sb.toString();
    }

    private void appendText(StringBuilder sb, ForeCastDto foreCastDto, boolean isValid) {
        if (isValid) {
            sb.append(String.format("Successfully imported forecast %s - %.2f%n", foreCastDto.getDayOfWeek(), foreCastDto.getMaxTemperature()));
        } else {
            sb.append(String.format("Invalid forecast%n"));
        }
    }

    @Override
    public String exportForecasts() {

        StringBuilder sb = new StringBuilder();

        forecastRepository.exportSundayForecast()
                .forEach(forecast -> sb.append(String.format("City: %s:\n" +
                                "-min temperature: %.2f\n" +
                                "--max temperature: %.2f\n" +
                                "---sunrise: %s\n" +
                                "----sunset: %s\n", forecast.getCity().getCityName(), forecast.getMinTemperature(),
                        forecast.getMaxTemperature(), forecast.getSunrise().toString(), forecast.getSunset().toString())));

        return sb.toString();
    }
}
