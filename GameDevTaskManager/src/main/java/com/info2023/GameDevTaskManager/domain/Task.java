package com.info2023.GameDevTaskManager.domain;

import com.info2023.GameDevTaskManager.enumeration.StatusEnum;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Task {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @JdbcTypeCode(SqlTypes.CHAR)
    @Column(updatable = false, nullable = false)
    private UUID idTask;
    private String description;
    @ManyToOne
    private Game game;
    @OneToOne
    private Developer responsibleDeveloper;
    private LocalDate deadline;
    @Enumerated(EnumType.STRING)
    private StatusEnum status;
}