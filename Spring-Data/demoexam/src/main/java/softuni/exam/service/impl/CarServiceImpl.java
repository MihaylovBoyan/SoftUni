package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.Car;
import softuni.exam.models.dto.CarDto;
import softuni.exam.repository.CarRepository;
import softuni.exam.service.CarService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {

    private static final String CARS_FILE_PATH = "src/main/resources/files/json/cars.json";

    private final CarRepository carRepository;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    public CarServiceImpl(CarRepository carRepository, Gson gson, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.carRepository = carRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return carRepository.count() > 0;
    }

    @Override
    public String readCarsFileContent() throws IOException {
        return Files.readString(Path.of(CARS_FILE_PATH));
    }

    @Override
    public String importCars() throws IOException {

        StringBuilder sb = new StringBuilder();

        Arrays.stream(gson.fromJson(readCarsFileContent(), CarDto[].class))
                .filter(carDto -> {
                    boolean isValid = validationUtil.isValid(carDto);
                    appendText(sb, carDto, isValid);
                    return isValid;
                })
                .map(carDto -> modelMapper.map(carDto, Car.class))
                .forEach(carRepository::save);

        return sb.toString();
    }

    private void appendText(StringBuilder sb, CarDto carDto, boolean isValid) {
        if (isValid) {
            sb.append(String.format("Successfully imported car %s - %s%n", carDto.getModel(), carDto.getMake()));
        } else {
            sb.append(String.format("Invalid car%n"));
        }
    }

    @Override
    public String getCarsOrderByPicturesCountThenByMake() {

        StringBuilder sb = new StringBuilder();

        carRepository.findAllByPicturesCountOrderByMake()
                .forEach(car -> sb.append(String.format("\"Car make - %s, model - %s\n" +
                                "\tKilometers - %d\n" +
                                "\tRegistered on - %s\n" +
                                "\tNumber of pictures - %d\n", car.getMake(), car.getModel(), car.getKilometers(),
                        car.getRegisteredOn(), car.getPictures().size())));

        return sb.toString();
    }

    @Override
    public Car findById(Long car) {
        return carRepository.findById(car).orElse(null);
    }
}
