package com.example.football.service.impl;

import com.example.football.models.dto.TeamDto;
import com.example.football.models.entity.Team;
import com.example.football.repository.TeamRepository;
import com.example.football.service.TeamService;
import com.example.football.service.TownService;
import com.example.football.util.ValidationUtil;
import com.example.football.util.XmlParser;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

@Service
public class TeamServiceImpl implements TeamService {

    private static final String FILE_PATH = "src/main/resources/files/json/teams.json";

    private final TeamRepository teamRepository;
    private final ModelMapper modelMapper;
    private final Gson gson;
    private final XmlParser xmlParser;
    private final ValidationUtil validationUtil;
    private final TownService townService;

    public TeamServiceImpl(TeamRepository teamRepository, ModelMapper modelMapper, Gson gson, XmlParser xmlParser, ValidationUtil validationUtil, TownService townService) {
        this.teamRepository = teamRepository;
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.xmlParser = xmlParser;
        this.validationUtil = validationUtil;
        this.townService = townService;
    }

    @Override
    public boolean areImported() {
        return teamRepository.count() > 0;
    }

    @Override
    public String readTeamsFileContent() throws IOException {
        return Files.readString(Path.of(FILE_PATH));
    }

    @Override
    public String importTeams() throws IOException {

        StringBuilder sb = new StringBuilder();

        Arrays.stream(gson.fromJson(readTeamsFileContent(), TeamDto[].class))
                .filter(teamDto -> {

                    boolean isValid = validationUtil.isValid(teamDto) &&
                            !teamRepository.existsByName(teamDto.getName());

                    sb.append(isValid ? String.format("Successfully imported Team %s - %d",
                            teamDto.getName(), teamDto.getFanBase()) : "Invalid team")
                            .append(System.lineSeparator());

                    return isValid;

                }).map(teamDto -> {

            Team team = modelMapper.map(teamDto, Team.class);
            team.setTown(townService.findFirstBy(teamDto.getName()));

            return team;
        }).forEach(teamRepository::save);


        return sb.toString();
    }


    @Override
    public Team findByName(String name) {
        return teamRepository.findFirstByName(name).orElse(null);
    }

}
