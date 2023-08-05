package com.info2023.GameDevTaskManager.model.dto.developer;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class DeveloperResponseDTO {
    private String idDev;
    private String name;
    private String email;
}