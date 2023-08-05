package com.info2023.GameDevTaskManager.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Game {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @JdbcTypeCode(SqlTypes.CHAR)
    @Column(updatable = false, nullable = false)
    private UUID idGame;
    private String title;
    private String description;
    @OneToMany(mappedBy = "game")
    private List<Developer> developers = new ArrayList<>();
    @OneToMany(mappedBy = "game")
    private List<Task> tasks = new ArrayList<>();
    private LocalDate releaseDate;
    private boolean finished;
}