package com.info2023.GameDevTaskManager.service.game.impl;

import com.info2023.GameDevTaskManager.domain.Developer;
import com.info2023.GameDevTaskManager.domain.Game;
import com.info2023.GameDevTaskManager.exceptions.EntityNotFoundException;
import com.info2023.GameDevTaskManager.mapper.game.GameMapper;
import com.info2023.GameDevTaskManager.model.dto.game.GameDTO;
import com.info2023.GameDevTaskManager.repository.developer.DeveloperRepository;
import com.info2023.GameDevTaskManager.repository.game.GameRepository;
import com.info2023.GameDevTaskManager.service.game.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GameServiceImpl implements GameService {

    private final GameRepository gameRepository;
    private final GameMapper gameMapper;
    private final DeveloperRepository developerRepository;

    @Override
    public List<Game> getAllGames() {
        return gameRepository.findAll();
    }

    @Override
    public Game createGame(GameDTO gameDTO) {
        Game game = gameMapper.gameDTOtoGame(gameDTO);
        return gameRepository.save(game);
    }

    @Override
    public Optional<Game> updateGame(UUID idGame, Game gameUpdated) {
        Optional<Game> gameOptional = gameRepository.findById(idGame);
        if (gameOptional.isPresent()){
            updatingGame(gameOptional.get(), gameUpdated);
            return Optional.of(gameRepository.saveAndFlush(gameOptional.get()));
        }else {
            return Optional.empty();
        }
    }

    @Override
    public boolean deleteGame(UUID idGame) {
        if (gameRepository.existsById(idGame)){
            gameRepository.deleteById(idGame);
            return true;
        }
        return false;
    }

    @Override
    public void assignDeveloperToGame(UUID developerId, UUID gameId) {
        Optional<Developer> developerOptional = developerRepository.findById(developerId);
        Optional<Game> gameOptional = gameRepository.findById(gameId);
        if (developerOptional.isPresent() && gameOptional.isPresent()){
            Developer developer = developerOptional.get();
            Game game = gameOptional.get();
            game.getDevelopers().add(developer);
            gameRepository.save(game);
        }else {
            throw new EntityNotFoundException("No se encontro el desarrollador o el juego");
        }
    }

    @Override
    public List<GameDTO> getGameFinished() {
        List<GameDTO> gameDTOList = new ArrayList<>();
        for (Game game:gameRepository.findAll()) {
            if (game.isFinished()){
                gameDTOList.add(gameMapper.gameToGameDTO(game));
            }
        }
        return gameDTOList;
    }

    @Override
    public List<GameDTO> getGameInProgress() {
        List<GameDTO> gameDTOList = new ArrayList<>();
        for (Game game:gameRepository.findAll()) {
            if (!game.isFinished()){
                gameDTOList.add(gameMapper.gameToGameDTO(game));
            }
        }
        return gameDTOList;
    }

    @Override
    public List<GameDTO> getAllDevsInGame() {
        List<GameDTO> developerDTOList = new ArrayList<>();
        for (Game devs:gameRepository.findAll()) {
            developerDTOList.add(gameMapper.gameToGameDTO(devs));
        }
        return developerDTOList;
    }


    private void updatingGame(Game game, Game gameUpdated){
        if (gameUpdated.getTitle() != null){
            game.setTitle(gameUpdated.getTitle());
        }
        if (gameUpdated.getDescription() != null){
            game.setDescription(gameUpdated.getDescription());
        }
        if (gameUpdated.getDevelopers() != null){
            game.setDevelopers(gameUpdated.getDevelopers());
        }
        if (gameUpdated.getTasks() != null){
            game.setTasks(gameUpdated.getTasks());
        }
        if (gameUpdated.getReleaseDate() != null){
            game.setReleaseDate(gameUpdated.getReleaseDate());
        }
    }
}