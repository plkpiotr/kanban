package com.plkpiotr.kanban.domain;

import javax.persistence.*;
import java.util.List;

/**
 * Represents a company.
 * A company can have many employees and many projects.
 */
@Entity
@Table(name = "companies")
public class Company {

    @Id
    @Column(columnDefinition = "serial")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 15)
    private String name;

    @OneToMany(mappedBy = "company")
    private List<Project> listOfProjects;

    @OneToMany(mappedBy = "company")
    private List<Employee> listOfEmployees;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Project> getListOfProjects() {
        return listOfProjects;
    }

    public void setListOfProjects(List<Project> listOfProjects) {
        this.listOfProjects = listOfProjects;
    }

    public List<Employee> getListOfEmployees() {
        return listOfEmployees;
    }

    public void setListOfEmployees(List<Employee> listOfEmployees) {
        this.listOfEmployees = listOfEmployees;
    }
}
