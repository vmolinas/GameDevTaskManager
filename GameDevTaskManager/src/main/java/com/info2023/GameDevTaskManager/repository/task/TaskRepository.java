package com.info2023.GameDevTaskManager.repository.task;

import com.info2023.GameDevTaskManager.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface TaskRepository extends JpaRepository<Task, UUID> {
}