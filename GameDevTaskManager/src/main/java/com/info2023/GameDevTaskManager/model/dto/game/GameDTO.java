package com.info2023.GameDevTaskManager.model.dto.game;

import com.info2023.GameDevTaskManager.model.dto.developer.DeveloperDTO;
import com.info2023.GameDevTaskManager.model.dto.task.TaskDTO;
import lombok.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class GameDTO {
    private String idDev;
    private String title;
    private String description;
    private String releaseDate;
    private List<DeveloperDTO> developerDTOList;
    private List<TaskDTO> taskDTOList;
    private boolean finished;
}