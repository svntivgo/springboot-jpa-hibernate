package com.example.demo.services;

import com.example.demo.models.Project;
import com.example.demo.repositories.IProjectJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {
    @Autowired
    IProjectJpaRepository projectRepository;

    public Project guardarProject (Project project) {
        return projectRepository.save(project);
    }
}
