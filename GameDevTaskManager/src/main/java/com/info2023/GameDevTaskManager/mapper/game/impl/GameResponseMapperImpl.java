package com.info2023.GameDevTaskManager.mapper.game.impl;

import com.info2023.GameDevTaskManager.domain.Developer;
import com.info2023.GameDevTaskManager.domain.Game;
import com.info2023.GameDevTaskManager.mapper.developer.DeveloperResponseMapper;
import com.info2023.GameDevTaskManager.mapper.game.GameResponseMapper;
import com.info2023.GameDevTaskManager.model.dto.developer.DeveloperResponseDTO;
import com.info2023.GameDevTaskManager.model.dto.game.GameResponseDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class GameResponseMapperImpl implements GameResponseMapper {

    private final DeveloperResponseMapper developerResponseMapper;
    @Override
    public GameResponseDTO gameToGameResponseDTO(Game game) {
        GameResponseDTO gameResponseDTO = GameResponseDTO.builder()
                .title(game.getTitle())
                .description(game.getDescription())
                .releaseDate(game.getReleaseDate().toString())
                .finished(game.isFinished())
                .build();

        List<DeveloperResponseDTO> developerResponseDTOS = new ArrayList<>();
        for (Developer developer:game.getDevelopers()) {
            developerResponseDTOS.add(developerResponseMapper.developerToDeveloperDTO(developer));
        }
        gameResponseDTO.setDeveloperResponseDTOS(developerResponseDTOS);
        return gameResponseDTO;
    }
}