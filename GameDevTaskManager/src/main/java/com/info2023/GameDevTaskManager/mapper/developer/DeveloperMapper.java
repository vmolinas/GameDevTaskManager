package com.info2023.GameDevTaskManager.mapper.developer;

import com.info2023.GameDevTaskManager.domain.Developer;
import com.info2023.GameDevTaskManager.model.dto.developer.DeveloperDTO;

public interface DeveloperMapper {
    Developer developerDtoToDeveloper(DeveloperDTO developerDTO);
    DeveloperDTO developerToDeveloperDto(Developer developer);
}