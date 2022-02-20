package com.example.demo.services;

import com.example.demo.models.Employee;
import com.example.demo.repositories.IEmployeeJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    IEmployeeJpaRepository employeeRepository;

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
}
