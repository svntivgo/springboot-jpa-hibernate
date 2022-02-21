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

    /**
     * Crea y guarda un empleado en la base de datos
     * @param employee Objeto con atributos del empleado
     * @return
     */
    @PostMapping("/create")
    public Employee guardarEmployee (@RequestBody Employee employee) {
        return this.employeeService.guardarEmployee(employee);
    }

    /**
     * Elimina un empleado de la base de datos
     * @param id del empleado en la base de datos
     * @return
     */
    @DeleteMapping(path = "/delete/{id}")
    public Boolean eliminarEmployee (@PathVariable("id") Long id) {
        return this.employeeService.eliminarEmployee(id);
    }

    /**
     * Actualiza los datos del empleado
     * @param employee Objeto empleado incluido su ID
     * @return
     */
    @PutMapping(path = "/update")
    public Employee actualizarEmployee(Employee employee) {
        return this.employeeService.actualizarEmployee(employee);
    }

    /**
     * Obtiene todos los empleados en la base de datos
     * @return
     */
    @GetMapping
    public List<Employee> obtenerTodosEmployee() {
        return this.employeeService.obtenerTodosEmployee();
    }

    /**
     * Obtiene un empleado de la base de datos dado su ID de empleado
     * @param id de empleado asignado por la empresa
     * @return
     */
    @GetMapping(path = "/get/{employeeId}")
    public Employee obtenerEmployeePorEmployeeId(@PathVariable("employeeId") String id) {
        return this.employeeService.obtenerEmployeePorEmployeeId(id);
    }

    /**
     * Asigna un proyecto al empleado
     * @param employeeId ID del empleado en la empresa
     * @param projectId ID del proyecto en la base de datos
     * @return
     */
    @PutMapping(path = "/new-project/q")
    public Employee asignarProjectAEmployee (@RequestParam("employeeId") String employeeId, @RequestParam("projectId") Long projectId) {
        return this.employeeService.asignarProjectAEmployee(employeeId, projectId);
    }
}
