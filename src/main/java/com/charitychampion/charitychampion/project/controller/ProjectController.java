package com.charitychampion.charitychampion.project.controller;

import com.charitychampion.charitychampion.project.model.Project;
import com.charitychampion.charitychampion.project.requests.CreateProjectRequest;
import com.charitychampion.charitychampion.project.services.ProjectService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    private final ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @PostMapping("")
    public ResponseEntity<Project> create(@RequestBody @Valid CreateProjectRequest projectRequest) {
        Project project = new Project();
        project.setTitle(projectRequest.title);
        project.setStatus(projectRequest.status);
        project.setType(projectRequest.type);
        project.setDescription(projectRequest.description);
        project.setNeededAmount(projectRequest.neededAmount);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(this.projectService.save(project));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Project> update(@PathVariable UUID id, @RequestBody @Valid CreateProjectRequest projectRequest) {
        Optional<Project> OptionalProject = this.projectService.findById(id);

        // Check if the project exists
        if (OptionalProject.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Project project = OptionalProject.get();
        project.setTitle(projectRequest.title);
        project.setStatus(projectRequest.status);
        project.setType(projectRequest.type);
        project.setDescription(projectRequest.description);
        project.setNeededAmount(projectRequest.neededAmount);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(this.projectService.save(project));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable UUID id) {
        Optional<Project> OptionalProject = this.projectService.findById(id);

        // Check if the project exists
        if (OptionalProject.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        this.projectService.delete(id);
        return ResponseEntity
                .status(HttpStatus.OK).build();
    }

    @GetMapping("")
    public ResponseEntity<List<Project>> getAll() {
        return ResponseEntity.ok(this.projectService.findAll());
    }
}
