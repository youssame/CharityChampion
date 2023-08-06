package com.charitychampion.charitychampion.project.controller;
import com.charitychampion.charitychampion.project.services.ProjectService;
import com.google.inject.matcher.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.runner.RunWith;
//import org.mockito.Mock;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.HttpStatus;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import com.charitychampion.charitychampion.project.enums.EProjectStatus;
import com.charitychampion.charitychampion.project.enums.EProjectType;
import com.charitychampion.charitychampion.project.model.Project;
import com.charitychampion.charitychampion.project.requests.CreateProjectRequest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectControllerTest {
    @Autowired
    private ProjectController projectController;
    @Autowired
    private ProjectService projectService;

    @Test
    public void whenRequestValid_thenProjectCreated() {
        Project returnProject = new Project();
        returnProject.setTitle("This");
        returnProject.setDescription("This");
        returnProject.setType(EProjectType.OTHER);
        returnProject.setStatus(EProjectStatus.OPEN);
    Mockito.when(projectService.save(Mockito.any(Project.class))).thenReturn(returnProject);
    CreateProjectRequest projectRequest = new CreateProjectRequest();
    projectRequest.description = "This is the first project";
    projectRequest.title = "Project 1";
    projectRequest.status = EProjectStatus.OPEN;
    projectRequest.type = EProjectType.OTHER;
    projectRequest.neededAmount = 100L;

    ResponseEntity<Project> resultProject = projectController.create(projectRequest);
    
    Assert.assertEquals(resultProject.getStatusCode(), HttpStatusCode.valueOf(201));
   }

}
