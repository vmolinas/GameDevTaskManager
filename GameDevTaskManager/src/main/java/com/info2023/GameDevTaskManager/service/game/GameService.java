package com.info2023.GameDevTaskManager.service.game;

import com.info2023.GameDevTaskManager.domain.Game;
import com.info2023.GameDevTaskManager.model.dto.game.GameDTO;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface GameService {
    Game createGame(GameDTO gameDTO);
    List<GameDTO> getGameFinished();
    List<GameDTO> getGameInProgress();
    List<GameDTO> getAllDevsInGame();
    List<Game> getAllGames();
    Optional<Game> updateGame(UUID idGame, Game gameUpdated);
    boolean deleteGame(UUID idGame);
    void assignDeveloperToGame(UUID developerId, UUID gameId);
}