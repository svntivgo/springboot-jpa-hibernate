package com.example.demo.services;

import com.example.demo.models.Employee;
import com.example.demo.models.Project;
import com.example.demo.repositories.IEmployeeJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    IEmployeeJpaRepository employeeRepository;

    @Autowired
    ProjectService projectService;

    public Employee guardarEmployee (Employee employee) {
        return employeeRepository.save(employee);
    }

    public Boolean eliminarEmployee (Long id) {
        try {
            employeeRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Employee actualizarEmployee (Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<Employee> obtenerTodosEmployee () {
        return employeeRepository.findAll();
    }

    public Employee obtenerEmployeePorEmployeeId (String id) {
        return employeeRepository.findByEmployeeId(id);
    }

    public Employee asignarProjectAEmployee (String employeeId, Long projectId) {
        Project newProject = projectService.obetenerProjectPorId(projectId).get();
        Employee employee = obtenerEmployeePorEmployeeId(employeeId);
        employee.getProjects().add(newProject);
        return employeeRepository.save(employee);
    }

    public Employee quitarProjectAEmployee (String employeeId, Long projectId) {
        Project newProject = projectService.obetenerProjectPorId(projectId).get();
        Employee employee = obtenerEmployeePorEmployeeId(employeeId);
        employee.getProjects().remove(newProject);
        return employeeRepository.save(employee);
    }
}
