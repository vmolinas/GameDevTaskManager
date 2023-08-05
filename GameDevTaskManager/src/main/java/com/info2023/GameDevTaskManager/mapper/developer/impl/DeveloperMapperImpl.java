package com.info2023.GameDevTaskManager.mapper.developer.impl;

import com.info2023.GameDevTaskManager.domain.Developer;
import com.info2023.GameDevTaskManager.mapper.developer.DeveloperMapper;
import com.info2023.GameDevTaskManager.model.dto.developer.DeveloperDTO;
import org.springframework.stereotype.Component;
import java.util.UUID;

@Component
public class DeveloperMapperImpl implements DeveloperMapper {
    @Override
    public Developer developerDtoToDeveloper(DeveloperDTO developerDTO) {
        return Developer.builder()
                .idDev(UUID.randomUUID())
                .name(developerDTO.getName())
                .email(developerDTO.getEmail())
                .build();
    }

    @Override
    public DeveloperDTO developerToDeveloperDto(Developer developer) {
        return DeveloperDTO.builder()
                .name(developer.getName())
                .email(developer.getEmail())
                .build();
    }
}