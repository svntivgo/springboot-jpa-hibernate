package com.example.demo;

import com.example.demo.models.Employee;
import com.example.demo.models.Project;
import com.example.demo.models.Role;
import com.example.demo.repositories.IEmployeeJpaRepository;
import com.example.demo.repositories.IProjectJpaRepository;
import com.example.demo.repositories.IRoleJpaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class EmployeeJpaRepositoryTest {

    @Autowired
    private IEmployeeJpaRepository repo;

    @Autowired
    private IRoleJpaRepository repoRole;

    @Autowired
    private IProjectJpaRepository repoProject;

    @Test
    public void saveEmployee () {

        Role admin = new Role("ROLE_ADMIN");
        Role dev = new Role("ROLE_DEV");

        admin = repoRole.save(admin);
        dev = repoRole.save(dev);

        Project projectOne = new Project("Project 1");
        Project projectTwo = new Project("Project 2");
        Project projectThree = new Project("Project 3");

        projectOne = repoProject.save(projectOne);
        projectTwo = repoProject.save(projectTwo);
        projectThree = repoProject.save(projectThree);

        Employee john = new Employee("John", "Smith", "empl123");
        Employee claire = new Employee("Claire", "Simpson", "empl124");

        repo.save(john);
        repo.save(claire);

        repo.flush();

        assertEquals(2, repo.findAll().size());
    }
}
