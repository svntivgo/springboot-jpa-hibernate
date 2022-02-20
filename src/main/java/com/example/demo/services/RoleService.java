package com.example.demo.services;

import com.example.demo.models.Role;
import com.example.demo.repositories.IRoleJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {

    @Autowired
    IRoleJpaRepository roleRepository;

    public Role guardarRole (Role role) {
        return roleRepository.save(role);
    }

    public Boolean eliminarRole (Long id) {
        try {
            roleRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Role actualizarRole (Role role) {
        return roleRepository.save(role);
    }

    public List<Role> obtenerTodosRole () {
        return (List<Role>) roleRepository.findAll();
    }

    public Optional<Role> obtenerRolePorId (Long id) {
        return roleRepository.findById(id);
    }

}
