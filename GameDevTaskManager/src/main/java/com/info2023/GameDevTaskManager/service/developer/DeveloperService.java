package com.info2023.GameDevTaskManager.service.developer;

import com.info2023.GameDevTaskManager.domain.Developer;
import com.info2023.GameDevTaskManager.model.dto.developer.DeveloperDTO;
import java.util.List;

public interface DeveloperService {
    Developer createDev(DeveloperDTO developerDTO);
    List<DeveloperDTO> getAllDevs();
}