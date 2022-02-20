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

    @PostMapping(path = "/create")
    public Role guardarRole (@RequestBody Role role) {
        return this.roleService.guardarRole(role);
    }

    @DeleteMapping(path = "/delete/{id}")
    public Boolean eliminarRole (@PathVariable("id") Long id) {
        return this.roleService.eliminarRole(id);
    }

    @PutMapping(path = "/update")
    public Role actualizarRole (@RequestBody Role role) {
        return this.roleService.actualizarRole(role);
    }

    @GetMapping
    public List<Role> obtenerTodosRole () {
        return this.roleService.obtenerTodosRole();
    }

    @GetMapping(path = "/get/{id}")
    public Optional<Role> obtenerRolePorId (@PathVariable("id") Long id) {
        return this.roleService.obtenerRolePorId(id);
    }
}
