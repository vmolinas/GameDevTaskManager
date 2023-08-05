package com.info2023.GameDevTaskManager.mapper.game;

import com.info2023.GameDevTaskManager.domain.Game;
import com.info2023.GameDevTaskManager.model.dto.game.GameResponseDTO;

public interface GameResponseMapper {
    GameResponseDTO gameToGameResponseDTO(Game game);
}