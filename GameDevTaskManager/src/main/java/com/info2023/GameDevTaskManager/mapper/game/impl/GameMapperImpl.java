package com.info2023.GameDevTaskManager.mapper.game.impl;

import com.info2023.GameDevTaskManager.domain.Developer;
import com.info2023.GameDevTaskManager.domain.Game;
import com.info2023.GameDevTaskManager.mapper.developer.DeveloperMapper;
import com.info2023.GameDevTaskManager.mapper.game.GameMapper;
import com.info2023.GameDevTaskManager.model.dto.developer.DeveloperDTO;
import com.info2023.GameDevTaskManager.model.dto.game.GameDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class GameMapperImpl implements GameMapper {

    private final DeveloperMapper developerMapper;

    @Override
    public Game gameDTOtoGame(GameDTO gameDTO) {
        return Game.builder()
                .idGame(UUID.randomUUID())
                .title(gameDTO.getTitle())
                .description(gameDTO.getDescription())
//                .releaseDate(getLocalDateTime(gameDTO.getReleaseDate()))
                .build();
    }

    @Override
    public GameDTO gameToGameDTO(Game game) {
        GameDTO gameDTO = GameDTO.builder()
                .idDev(game.getIdGame().toString())
                .title(game.getTitle())
                .description(game.getDescription())
                .releaseDate(game.getReleaseDate().toString())
                .build();
        if (!game.getDevelopers().isEmpty()){
            List<DeveloperDTO> developerDTOS = new ArrayList<>();
            for (Developer developer : game.getDevelopers()) {
                developerDTOS.add(developerMapper.developerToDeveloperDto(developer));
            }
            gameDTO.setDeveloperDTOList(developerDTOS);
        }
        return gameDTO;
    }

    private LocalDateTime getLocalDateTime(String date){
        if (!date.isBlank()){
            String[] parts = date.split("/");
            return LocalDateTime.of(Integer.parseInt(parts[0]),Integer.parseInt(parts[1]),Integer.parseInt(parts[2]),0,0);
        }
        return null;
    }

    private String getLocalDateTime(LocalDateTime localDateTime){
        StringBuffer stringBuffer = new StringBuffer();
        return stringBuffer.append(localDateTime.getYear())
                .append("/")
                .append(localDateTime.getMonthValue())
                .append("/")
                .append(localDateTime.getDayOfYear())
                .toString();
    }
}