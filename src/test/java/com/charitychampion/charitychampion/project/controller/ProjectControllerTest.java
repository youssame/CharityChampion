package com.charitychampion.charitychampion.project.controller;
import com.charitychampion.charitychampion.project.repositories.IProjectRepository;
import com.charitychampion.charitychampion.project.services.ProjectService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.Inject;
import com.google.inject.matcher.Matchers;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
//import org.mockito.Mock;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.HttpStatus;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import com.charitychampion.charitychampion.project.enums.EProjectStatus;
import com.charitychampion.charitychampion.project.enums.EProjectType;
import com.charitychampion.charitychampion.project.model.Project;
import com.charitychampion.charitychampion.project.requests.CreateProjectRequest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
//@SpringBootTest
@WebMvcTest(ProjectController.class)
//@ExtendWith(SpringExtension.class)
public class ProjectControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private ProjectService projectService;

    @MockBean
    private IProjectRepository iProjectRepository;

    @Before
    public void setUp(){
        iProjectRepository=mock(iProjectRepository.getClass());
        projectService=new ProjectService(iProjectRepository);
    }

    @Test
    public void whenRequestValid_thenProjectCreated() throws Exception {
    //given
        CreateProjectRequest projectRequest = new CreateProjectRequest();
        projectRequest.description = "description";
        projectRequest.title = "title";
        projectRequest.status = EProjectStatus.OPEN;
        projectRequest.type = EProjectType.POOR_FAMILY;
        projectRequest.neededAmount = 100L;

        Project project=new Project();
        project.setDescription("description");
        project.setStatus(EProjectStatus.OPEN);
        project.setTitle("title");
        project.setType(EProjectType.POOR_FAMILY);
        project.setNeededAmount(100L);

        when(projectService.save(project)).thenReturn(project);

        Project response=this.projectService.save(project);

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonPayload = objectMapper.writeValueAsString(response);
        //System.out.printf("json"+jsonPayload);
    //when
        final MvcResult result =mockMvc.perform(MockMvcRequestBuilders.post("/api/projects")
                        .contentType("application/json")
                        .content("{\"description\":\"description\",\"status\":\"OPEN\",\"title\":\"title\",\"type\":\"POOR_FAMILY\",\"neededAmount\":\"100\"}"))
                        //.content(objectMapper.writeValueAsString(project)))
                //.content(jsonPayload))
                        .andExpect(MockMvcResultMatchers.status().isCreated())
                        .andReturn();
    //then
        //assertThat(result.getResponse().getContentAsString()).isEqualTo(jsonPayload);
        //verify(this.projectService,times(1)).save(project);
   }

}
