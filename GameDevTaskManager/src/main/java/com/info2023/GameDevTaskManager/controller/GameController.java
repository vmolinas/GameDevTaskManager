package com.info2023.GameDevTaskManager.controller;

import com.info2023.GameDevTaskManager.domain.Game;
import com.info2023.GameDevTaskManager.exceptions.NotFoundException;
import com.info2023.GameDevTaskManager.model.dto.game.GameDTO;
import com.info2023.GameDevTaskManager.service.game.GameService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/application/v1/game")
@Slf4j
public class GameController {
    private final GameService gameService;

    @PostMapping() //--> REGISTRO DE JUEGOS
    public ResponseEntity createGame(@RequestBody GameDTO game) {
        log.info("Registered game");
        Game gameCreated = gameService.createGame(game);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/application/v1/game" + gameCreated.getIdGame());
        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @GetMapping("/finished")  // --> Visualización de juegos finalizados
    public List<GameDTO> getGamesFinished(){
        return gameService.getGameFinished();
    }

    @GetMapping("/inProgress")  // --> Visualización de juegos que se esten desarrollando
    public List<GameDTO> getGamesInProgress(){
        return gameService.getGameInProgress();
    }

    @GetMapping("/gameDevs")  // --> Visualización de los devs de un juego
    public List<GameDTO> getDevsInGame() {
        return gameService.getAllDevsInGame();
    }


    //***********************-----------*************************
    @GetMapping() //--> LISTAR TODOS LOS JUEGOS
    public List<Game> getAllGames(@RequestParam(required = false, name = "gameState") String gameState) {
        log.info("Games listed");
        return gameService.getAllGames();
    }

    @PutMapping("/{idGame}") //--> ACTUALIZAR JUEGO
    public ResponseEntity updateGame(@PathVariable(value = "idGame")UUID idGame, @RequestBody Game gameUpdated) throws NotFoundException {
        Optional<Game> gameOptional = gameService.updateGame(idGame,gameUpdated);
        if (gameOptional.isEmpty()){
            log.warn("Game not found, can't update");
            throw new NotFoundException();
        }else {
            log.info("Game updated");
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
    }

    @DeleteMapping("/{idGame}") //--> ELIMINAR JUEGO POR ID
    public ResponseEntity deleteGame(@PathVariable(value = "idGame")UUID idGame) throws NotFoundException {
        boolean isGameDeleted = gameService.deleteGame(idGame);
        if (isGameDeleted){
            log.info("Game deleted");
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }else {
            log.warn("Game not found, can't delete");
            throw new NotFoundException();
        }
    }
}