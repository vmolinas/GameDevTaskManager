package com.info2023.GameDevTaskManager.model.dto.game;

import com.info2023.GameDevTaskManager.model.dto.developer.DeveloperResponseDTO;
import com.info2023.GameDevTaskManager.model.dto.task.TaskResponseDTO;
import lombok.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class GameResponseDTO {
    private String title;
    private String description;
    private String releaseDate;
    private List<DeveloperResponseDTO> developerResponseDTOS;
    private List<TaskResponseDTO> taskResponseDTOS;
    private boolean finished;
}