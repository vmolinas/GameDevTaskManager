package com.info2023.GameDevTaskManager.repository.developer;

import com.info2023.GameDevTaskManager.domain.Developer;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.UUID;

public interface DeveloperRepository extends JpaRepository<Developer, UUID> {
    Optional<Developer> findDeveloperByNameIgnoreCase(String name);
}