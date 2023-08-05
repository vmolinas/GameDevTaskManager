package com.info2023.GameDevTaskManager.mapper.game;

import com.info2023.GameDevTaskManager.domain.Game;
import com.info2023.GameDevTaskManager.model.dto.game.GameDTO;

public interface GameMapper {
    Game gameDTOtoGame(GameDTO gameDTO);
    GameDTO gameToGameDTO(Game game);
}