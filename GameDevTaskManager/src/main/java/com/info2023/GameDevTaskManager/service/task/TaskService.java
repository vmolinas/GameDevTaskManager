package com.info2023.GameDevTaskManager.service.task;

import java.time.LocalDate;
import java.util.UUID;

public interface TaskService {
    void assignTaskToDeveloper(UUID gameId, UUID developerId, String taskDescription, LocalDate deadline);
}