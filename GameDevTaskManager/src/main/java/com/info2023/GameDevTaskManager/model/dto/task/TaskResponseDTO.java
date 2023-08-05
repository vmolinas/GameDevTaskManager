package com.info2023.GameDevTaskManager.model.dto.task;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class TaskResponseDTO {
    private String idTask;
    private String description;
    private String responsibleDeveloper;
    private String deadline;
    private String status;
}