package com.example.football.service.impl;

import com.example.football.models.dto.PlayerRootDto;
import com.example.football.models.entity.Player;
import com.example.football.models.entity.enums.Position;
import com.example.football.repository.PlayerRepository;
import com.example.football.service.PlayerService;
import com.example.football.service.StatService;
import com.example.football.service.TeamService;
import com.example.football.service.TownService;
import com.example.football.util.ValidationUtil;
import com.example.football.util.XmlParser;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;

@Service
public class PlayerServiceImpl implements PlayerService {

    private static final String FILE_PATH = "src/main/resources/files/xml/players.xml";

    private final PlayerRepository playerRepository;
    private final ModelMapper modelMapper;
    private final Gson gson;
    private final XmlParser xmlParser;
    private final ValidationUtil validationUtil;
    private final TownService townService;
    private final TeamService teamService;
    private final StatService statService;

    public PlayerServiceImpl(PlayerRepository playerRepository, ModelMapper modelMapper, Gson gson, XmlParser xmlParser, ValidationUtil validationUtil, TownService townService, TeamService teamService, StatService statService) {
        this.playerRepository = playerRepository;
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.xmlParser = xmlParser;
        this.validationUtil = validationUtil;
        this.townService = townService;
        this.teamService = teamService;
        this.statService = statService;
    }

    @Override
    public boolean areImported() {
        return playerRepository.count() > 0;
    }

    @Override
    public String readPlayersFileContent() throws IOException {
        return Files.readString(Path.of(FILE_PATH));
    }

    @Override
    public String importPlayers() throws JAXBException {

        StringBuilder sb = new StringBuilder();

        xmlParser.fromFile(FILE_PATH, PlayerRootDto.class)
                .getPlayers()
                .stream()
                .filter(playerDto -> {

                    boolean isValid = validationUtil.isValid(playerDto)
                            && !playerRepository.existsByEmail(playerDto.getEmail());

                    sb.append(isValid ? String.format("Successfully imported Player %s %s - %s",
                            playerDto.getFirstName(), playerDto.getLastName(),
                            playerDto.getPosition()) : "Invalid player")
                            .append(System.lineSeparator());


                    return isValid;
                })
                .map(playerDto -> {

                    Player player = modelMapper.map(playerDto, Player.class);
                    player.setTownId(townService.findFirstBy(playerDto.getTown().getName()));
                    player.setTeamId(teamService.findByName(playerDto.getName().getName()));
                    player.setStatId(statService.findById(playerDto.getId().getId()));

                    return player;
                })
                .forEach(playerRepository::save);


        return sb.toString();
    }

    @Override
    public String exportBestPlayers() {

        StringBuilder sb = new StringBuilder();

        playerRepository.findAllByBirthDateAfterAndBirthDateBeforeOrderBy(LocalDate.of(1995, 1, 1),
                LocalDate.of(2003, 1, 1))
                .forEach(player -> {
                    sb.append(String.format("Player - %s %s\n" +
                                    "\tPosition - %s\n" +
                                    "Team - %s\n" +
                                    "\tStadium - %s\n",
                            player.getFirstName(),
                            player.getLastName(),
                            player.getPosition().toString(),
                            player.getTeamId().getName(),
                            player.getTeamId().getStadiumName()

                    ));
                });

        return sb.toString();
    }
}
