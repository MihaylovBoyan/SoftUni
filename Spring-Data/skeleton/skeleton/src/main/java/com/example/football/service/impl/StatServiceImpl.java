package com.example.football.service.impl;

import com.example.football.models.dto.StatRootDto;
import com.example.football.models.entity.Stat;
import com.example.football.repository.StatRepository;
import com.example.football.service.StatService;
import com.example.football.util.ValidationUtil;
import com.example.football.util.XmlParser;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class StatServiceImpl implements StatService {

    private static final String FILE_PATH = "src/main/resources/files/xml/stats.xml";

    private final StatRepository statRepository;
    private final ModelMapper modelMapper;
    private final Gson gson;
    private final XmlParser xmlParser;
    private final ValidationUtil validationUtil;

    public StatServiceImpl(StatRepository statRepository, ModelMapper modelMapper, Gson gson, XmlParser xmlParser, ValidationUtil validationUtil) {
        this.statRepository = statRepository;
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.xmlParser = xmlParser;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return statRepository.count() > 0;
    }

    @Override
    public String readStatsFileContent() throws IOException {
        return Files.readString(Path.of(FILE_PATH));
    }

    @Override
    public String importStats() throws JAXBException {

        StringBuilder sb = new StringBuilder();


        xmlParser.fromFile(FILE_PATH, StatRootDto.class)
                .getStats()
                .stream()
                .filter(statDto -> {
                    boolean isValid = validationUtil.isValid(statDto) &&
                            !existInDatabase(statDto.getPassing(),
                                    statDto.getShooting(), statDto.getEndurance());
                    sb.append(isValid ? String.format("Successfully imported Stat %.2f - %.2f - %.2f",
                            statDto.getPassing(), statDto.getShooting(),
                            statDto.getEndurance()) : "Invalid Stat")
                            .append(System.lineSeparator());
                    return isValid;
                }).map(statDto -> modelMapper.map(statDto, Stat.class))
                .forEach(statRepository::save);


        return sb.toString();
    }

    @Override
    public boolean existInDatabase(double passing, double shooting, double endurance) {
        return statRepository.existsByPassingAndShootingAndEndurance(passing, shooting, endurance);
    }

    @Override
    public Stat findById(long id) {
       return statRepository.findById(id).orElse(null);
    }
}
