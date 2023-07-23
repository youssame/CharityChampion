package com.charitychampion.charitychampion.project.model;

import com.charitychampion.charitychampion.core.BaseEntity;
import com.charitychampion.charitychampion.project.enums.EProjectStatus;
import com.charitychampion.charitychampion.project.enums.EProjectType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Project extends BaseEntity {

    private String title;
    private String imageSrc;

    @Enumerated(EnumType.STRING)
    private EProjectType type;

    @Lob
    @Column(length = 1500)
    private String description;

    @Enumerated(EnumType.STRING)
    private EProjectStatus status;

    private Long neededAmount = 0L;
    private Long paidAmount = 0L;
}
