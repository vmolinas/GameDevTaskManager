package com.info2023.GameDevTaskManager.controller;

import com.info2023.GameDevTaskManager.domain.Developer;
import com.info2023.GameDevTaskManager.exceptions.EntityNotFoundException;
import com.info2023.GameDevTaskManager.model.dto.developer.DeveloperDTO;
import com.info2023.GameDevTaskManager.service.developer.DeveloperService;
import com.info2023.GameDevTaskManager.service.game.GameService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/application/v1/dev")
@Slf4j
public class DeveloperContoller {
    private final GameService gameService;
    private final DeveloperService devService;

    @PostMapping()  // --> Registro de desarrollador
    public ResponseEntity createDev(@RequestBody DeveloperDTO developerDTO) {
        log.info("Creation of new developer");
        Developer developerCreated = devService.createDev(developerDTO);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location","/application/v1/dev" + developerCreated.getIdDev());

        return new ResponseEntity(headers,HttpStatus.CREATED);
    }

    @GetMapping()  // --> Listar todos los desarrolladores
    public List<DeveloperDTO> getAllDevs(){
        log.info("Query by developers");
        return devService.getAllDevs();
    }

    @PostMapping("/assignDev")  // --> Asignación de un desarrollador a un juego
    public ResponseEntity<String> assignDeveloperToGame(@RequestParam UUID developerId, @RequestParam UUID gameId){
        try {
            gameService.assignDeveloperToGame(developerId, gameId);
            return ResponseEntity.ok("Desarrollador asignado exitosamente al juego");
        } catch (EntityNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}