package com.example.demo.repositories;

import com.example.demo.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEmployeeJpaRepository extends JpaRepository<Employee, Long> {
    Employee findByEmployeeId(String employeeId);
    List<Employee> findByLastName (String lastName);
}
