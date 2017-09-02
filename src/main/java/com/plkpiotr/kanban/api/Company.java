package com.plkpiotr.kanban.api;

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
    @GeneratedValue
    private long id;

    @Column(nullable = false, length = 15)
    private String name;

    @OneToMany(mappedBy = "company")
    private List<Project> listOfProjects;

    @OneToMany(mappedBy = "company")
    private List<Employee> listOfEmployees;
}
