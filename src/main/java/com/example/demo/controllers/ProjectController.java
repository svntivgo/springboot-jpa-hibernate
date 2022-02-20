package com.example.demo.controllers;

import com.example.demo.models.Project;
import com.example.demo.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/project")
public class ProjectController {

    @Autowired
    ProjectService projectService;

    @PostMapping(path = "/create")
    public Project guardarProject (@RequestBody Project project) {
        return this.projectService.guardarProject(project);
    }

    @DeleteMapping(path = "/delete/{id}")
    public Boolean eliminarProject (@PathVariable("id") Long id) {
        return this.projectService.eliminarProject(id);
    }

    @PutMapping(path = "/update")
    public Project actualizarProject (@RequestBody Project project) {
        return this.projectService.actualizarProject(project);
    }

    @GetMapping
    public List<Project> obtenerTodosProject () {
        return this.projectService.obtenerTodosProject();
    }

    @GetMapping(path = "/get/{id}")
    public Optional<Project> obtenerProjectPorId (@PathVariable("id") Long id) {
        return this.projectService.obetenerProjectPorId(id);
    }
}
