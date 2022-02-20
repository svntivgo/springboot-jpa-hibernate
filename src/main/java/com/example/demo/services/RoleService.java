package com.example.demo.services;

import com.example.demo.models.Role;
import com.example.demo.repositories.IRoleJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    IRoleJpaRepository roleRepository;

    public Role guardarRole (Role role) {
        return roleRepository.save(role);
    }

}
