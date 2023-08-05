package com.info2023.GameDevTaskManager.model.dto.developer;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class DeveloperDTO {
    private String idDev;
    private String name;
    private String email;
    private String teamRole;
}