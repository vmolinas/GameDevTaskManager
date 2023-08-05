package com.info2023.GameDevTaskManager.mapper.developer;

import com.info2023.GameDevTaskManager.domain.Developer;
import com.info2023.GameDevTaskManager.model.dto.developer.DeveloperResponseDTO;

public interface DeveloperResponseMapper {
    DeveloperResponseDTO developerToDeveloperDTO(Developer developer);
}