package com.info2023.GameDevTaskManager.controller;

import com.info2023.GameDevTaskManager.exceptions.EntityNotFoundException;
import com.info2023.GameDevTaskManager.service.task.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDate;
import java.util.UUID;

@RestController
@AllArgsConstructor
public class TaskController {
    private final TaskService taskService;

    @PostMapping("/assignTask")  // --> Asignación de tareas:
    public ResponseEntity<String> assignTaskToDeveloper(@RequestParam UUID taskId, UUID devId, String description, LocalDate deadLine){
        try {
            taskService.assignTaskToDeveloper(taskId, devId, description, deadLine);
            return ResponseEntity.ok("Tarea asignada exitosamente al desarrollador");
        } catch (EntityNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    // Visualización de tareas: Permite ver todas las tareas asignadas a un desarrollador en particular, incluyendo su descripción, estado y fecha límite.
    // Actualización de estado de tareas: Permite marcar una tarea como completada o cambiar su estado a "en progreso".
    // Búsqueda de tareas: Permite buscar tareas por estado (pendiente, en progreso, completada) o por fecha límite.
    // Búsqueda de tareas por juego: Permite buscar tareas a partir de indicar un videojuego
    // Búsqueda de tareas fuera del plazo límite: Permite buscar tareas que no se completaron en el plazo límite.

}