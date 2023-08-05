package com.info2023.GameDevTaskManager.mapper.developer.impl;

import com.info2023.GameDevTaskManager.domain.Developer;
import com.info2023.GameDevTaskManager.mapper.developer.DeveloperResponseMapper;
import com.info2023.GameDevTaskManager.model.dto.developer.DeveloperResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class DeveloperResponseMapperImpl implements DeveloperResponseMapper {
    @Override
    public DeveloperResponseDTO developerToDeveloperDTO(Developer developer) {
        return DeveloperResponseDTO.builder()
                .idDev(developer.getIdDev().toString())
                .name(developer.getName())
                .email(developer.getEmail())
                .build();
    }
}