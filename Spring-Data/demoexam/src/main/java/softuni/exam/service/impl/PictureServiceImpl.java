package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.Picture;
import softuni.exam.models.dto.PictureDto;
import softuni.exam.repository.PictureRepository;
import softuni.exam.service.CarService;
import softuni.exam.service.PictureService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

@Service
public class PictureServiceImpl implements PictureService {

    private static final String PICTURE_FILE_PATH = "src/main/resources/files/json/pictures.json";

    private final PictureRepository pictureRepository;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final CarService carService;

    public PictureServiceImpl(PictureRepository pictureRepository, Gson gson, ModelMapper modelMapper, ValidationUtil validationUtil, CarService carService) {
        this.pictureRepository = pictureRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.carService = carService;
    }

    @Override
    public boolean areImported() {
        return pictureRepository.count() > 0;
    }

    @Override
    public String readPicturesFromFile() throws IOException {
        return Files.readString(Path.of(PICTURE_FILE_PATH));
    }

    @Override
    public String importPictures() throws IOException {

        StringBuilder sb = new StringBuilder();

        Arrays.stream(gson.fromJson(readPicturesFromFile(), PictureDto[].class))
                .filter(pictureDto -> {
                    boolean isValid = validationUtil.isValid(pictureDto);
                    appendText(sb, pictureDto, isValid);
                    return isValid;
                })
                .map(pictureDto -> {
                    Picture pic = modelMapper.map(pictureDto, Picture.class);
                    pic.setCar(carService.findById(pictureDto.getCar()));
                    return pic;
                }).forEach(pictureRepository::save);


        return sb.toString();
    }

    private void appendText(StringBuilder sb, PictureDto pictureDto, boolean isValid) {
        if (isValid) {
            sb.append(String.format("Successfully import picture - %s%n", pictureDto.getName()));
        } else {
            sb.append(String.format("Invalid picture%n"));
        }
    }
}
