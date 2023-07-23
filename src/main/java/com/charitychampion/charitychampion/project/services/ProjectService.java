package com.charitychampion.charitychampion.project.services;

import com.charitychampion.charitychampion.project.model.Project;
import com.charitychampion.charitychampion.project.repositories.IProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProjectService {

    private final IProjectRepository projectRepository;

    @Autowired
    public ProjectService(IProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public List<Project> findAll() {
        return this.projectRepository.findAll();
    }

    public Project save(Project project) {
        return this.projectRepository.save(project);
    }

    public Optional<Project> findById(UUID id) {
        return this.projectRepository.findById(id);
    }

    public void delete(UUID id) {
        this.projectRepository.deleteById(id);
    }
}
