package com.info2023.GameDevTaskManager.repository.game;

import com.info2023.GameDevTaskManager.domain.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface GameRepository extends JpaRepository<Game, UUID> {
    // Query Methods
    Optional<Game> findGameByTitleEqualsIgnoreCase(String title);
    Optional<Game> findGameFinished(boolean finished);
    List<Game> findGamesInProgress();
}