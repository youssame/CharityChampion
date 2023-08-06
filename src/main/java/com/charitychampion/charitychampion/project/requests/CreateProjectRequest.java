package com.charitychampion.charitychampion.project.requests;

import com.charitychampion.charitychampion.project.enums.EProjectStatus;
import com.charitychampion.charitychampion.project.enums.EProjectType;
import jakarta.validation.constraints.NotBlank;


public class CreateProjectRequest {
    @NotBlank
    public String title;
    // File -> Validation -> Rename -> Storage specific path -> Save path in db
    // private String imageSrc;
    @NotBlank
    public String description;
    public EProjectType type = EProjectType.OTHER;
    public EProjectStatus status = EProjectStatus.OPEN;
    public Long neededAmount = 0L;
}
