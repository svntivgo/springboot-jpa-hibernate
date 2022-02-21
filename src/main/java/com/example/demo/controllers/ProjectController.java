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

    /**
     * Crea y guarda un projecto en la base de datos
     * @param project Objeto project con los atributos de un proyecto
     * @return
     */
    @PostMapping(path = "/create")
    public Project guardarProject (@RequestBody Project project) {
        return this.projectService.guardarProject(project);
    }

    /**
     * Elimina un proyecto de la base de datos
     * @param id del proyecto en la base de datos
     * @return
     */
    @DeleteMapping(path = "/delete/{id}")
    public Boolean eliminarProject (@PathVariable("id") Long id) {
        return this.projectService.eliminarProject(id);
    }

    /**
     * Actualiza y modifica datos de un proyecto
     * @param project Objeto project incluido su ID en base de datos
     * @return
     */
    @PutMapping(path = "/update")
    public Project actualizarProject (@RequestBody Project project) {
        return this.projectService.actualizarProject(project);
    }

    /**
     * Obtiene todos los proyectos almacenados en la base de datos
     * @return
     */
    @GetMapping
    public List<Project> obtenerTodosProject () {
        return this.projectService.obtenerTodosProject();
    }

    /**
     * Obtiene un proyecto de la base de datos dado su id
     * @param id del proyecto en la base de datos
     * @return
     */
    @GetMapping(path = "/get/{id}")
    public Optional<Project> obtenerProjectPorId (@PathVariable("id") Long id) {
        return this.projectService.obetenerProjectPorId(id);
    }
}
