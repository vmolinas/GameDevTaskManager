package com.info2023.GameDevTaskManager.service.developer.impl;

import com.info2023.GameDevTaskManager.domain.Developer;
import com.info2023.GameDevTaskManager.mapper.developer.DeveloperMapper;
import com.info2023.GameDevTaskManager.model.dto.developer.DeveloperDTO;
import com.info2023.GameDevTaskManager.repository.developer.DeveloperRepository;
import com.info2023.GameDevTaskManager.service.developer.DeveloperService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DeveloperServiceImpl implements DeveloperService {

    private final DeveloperRepository developerRepository;
    private final DeveloperMapper developerMapper;

    @Override
    public Developer createDev(DeveloperDTO developerDTO) {
        Developer developer = developerMapper.developerDtoToDeveloper(developerDTO);
        return developerRepository.save(developer);
    }
    @Override
    public List<DeveloperDTO> getAllDevs() {
        List<DeveloperDTO> listDev = new ArrayList<>();
        for (Developer developer: developerRepository.findAll()){
            listDev.add(developerMapper.developerToDeveloperDto(developer));
        }
        return listDev;
    }
}