package com.charitychampion.charitychampion.feature.project.model;

import com.charitychampion.charitychampion.feature.project.enums.EProjectStatus;
import com.charitychampion.charitychampion.feature.project.enums.EProjectType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID )
    private UUID id;

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

    @CreatedDate
    private Date creationAt;
    @LastModifiedDate
    private Date updatedAt;
}
