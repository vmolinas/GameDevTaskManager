package com.info2023.GameDevTaskManager.domain;

import com.info2023.GameDevTaskManager.enumeration.RoleEnum;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Developer {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @JdbcTypeCode(SqlTypes.CHAR)
    @Column(updatable = false, nullable = false)
    private UUID idDev;
    private String name;
    private String email;
    @Enumerated(EnumType.STRING)
    private RoleEnum teamRole;
    @ManyToOne
    private Game game;
}