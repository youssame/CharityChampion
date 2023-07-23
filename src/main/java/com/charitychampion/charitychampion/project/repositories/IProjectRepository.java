package com.charitychampion.charitychampion.project.repositories;

import com.charitychampion.charitychampion.project.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IProjectRepository extends JpaRepository<Project, UUID> {
}
