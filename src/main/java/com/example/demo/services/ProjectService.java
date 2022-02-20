package com.example.demo.services;

import com.example.demo.models.Project;
import com.example.demo.repositories.IProjectJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {
    @Autowired
    IProjectJpaRepository projectRepository;

    public Project guardarProject (Project project) {
        return projectRepository.save(project);
    }

    public Boolean eliminarProject (Long id) {
        try {
            projectRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Project actualizarProject (Project project) {
        return projectRepository.save(project);
    }

    public List<Project> obtenerTodosProject () {
        return projectRepository.findAll();
    }

    public Optional<Project> obetenerProjectPorId (Long id) {
        return projectRepository.findById(id);
    }
}
