package com.example.demo.services;

import com.example.demo.models.Employee;
import com.example.demo.repositories.IEmployeeJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    IEmployeeJpaRepository employeeRepository;

    public Employee guardarEmployee (Employee employee) {
        return employeeRepository.save(employee);
    }
}
