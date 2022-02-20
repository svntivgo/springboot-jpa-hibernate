package com.example.demo.controllers;

import com.example.demo.models.Employee;
import com.example.demo.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping("/create")
    public Employee guardarEmployee (@RequestBody Employee employee) {
        return this.employeeService.guardarEmployee(employee);
    }

    @DeleteMapping(path = "/delete/{id}")
    public Boolean eliminarEmployee (@PathVariable("id") Long id) {
        return this.employeeService.eliminarEmployee(id);
    }

    @PutMapping(path = "/update")
    public Employee actualizarEmployee(Employee employee) {
        return this.employeeService.actualizarEmployee(employee);
    }

    @GetMapping
    public List<Employee> obtenerTodosEmployee() {
        return this.employeeService.obtenerTodosEmployee();
    }

    @GetMapping(path = "/get/{employeeId}")
    public Employee obtenerEmployeePorEmployeeId(@PathVariable("employeeId") String id) {
        return this.employeeService.obtenerEmployeePorEmployeeId(id);
    }
}
