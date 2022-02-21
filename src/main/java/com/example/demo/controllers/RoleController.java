package com.example.demo.controllers;

import com.example.demo.models.Role;
import com.example.demo.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/role")
public class RoleController {

    @Autowired
    RoleService roleService;

    /**
     * Crea y guarda un nuevo rol
     * @param role objeto role
     * @return
     */
    @PostMapping(path = "/create")
    public Role guardarRole (@RequestBody Role role) {
        return this.roleService.guardarRole(role);
    }

    /**
     * Elimina un rol de la base de datos dado su ID
     * @param id del rol en la base de datos
     * @return
     */
    @DeleteMapping(path = "/delete/{id}")
    public Boolean eliminarRole (@PathVariable("id") Long id) {
        return this.roleService.eliminarRole(id);
    }

    /**
     * Actualiza y modifica un rol en la base de datos
     * @param role objeto rol incluido su ID en la base de datos
     * @return
     */
    @PutMapping(path = "/update")
    public Role actualizarRole (@RequestBody Role role) {
        return this.roleService.actualizarRole(role);
    }

    /**
     * Obtiene todos los roles almacenados en la base de datos
     * @return
     */
    @GetMapping
    public List<Role> obtenerTodosRole () {
        return this.roleService.obtenerTodosRole();
    }

    /**
     * Obtiene un rol dado su ID
     * @param id del rol en la base de datos
     * @return
     */
    @GetMapping(path = "/get/{id}")
    public Optional<Role> obtenerRolePorId (@PathVariable("id") Long id) {
        return this.roleService.obtenerRolePorId(id);
    }
}
