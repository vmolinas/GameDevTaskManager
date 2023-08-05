package com.info2023.GameDevTaskManager.service.task.impl;

import com.info2023.GameDevTaskManager.domain.Developer;
import com.info2023.GameDevTaskManager.domain.Game;
import com.info2023.GameDevTaskManager.domain.Task;
import com.info2023.GameDevTaskManager.exceptions.EntityNotFoundException;
import com.info2023.GameDevTaskManager.repository.developer.DeveloperRepository;
import com.info2023.GameDevTaskManager.repository.game.GameRepository;
import com.info2023.GameDevTaskManager.repository.task.TaskRepository;
import com.info2023.GameDevTaskManager.service.task.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;
    private final DeveloperRepository developerRepository;
    private final GameRepository gameRepository;

    @Override
    public void assignTaskToDeveloper(UUID gameId, UUID developerId, String taskDescription, LocalDate deadline) {
        Optional<Game> gameOptional = gameRepository.findById(gameId);
        Optional<Developer> developerOptional = developerRepository.findById(developerId);
        if (gameOptional.isPresent() && developerOptional.isPresent()){
            Game game = gameOptional.get();
            Developer developer = developerOptional.get();
            Task task = new Task();
            task.setDescription(taskDescription);
            task.setDeadline(deadline);
            task.setResponsibleDeveloper(developer);
            task.setGame(game);
            taskRepository.save(task);
        } else {
            throw new EntityNotFoundException("No se encontro el desarrollador o la tarea");
        }
    }
}