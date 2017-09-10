package com.plkpiotr.kanban.domain;

import javax.persistence.*;
import java.util.List;

/**
 * Represents a project.
 * A project belongs to a company, it can have many employees and many tasks.
 */
@Entity
@Table(name = "projects")
public class Project {

    @Id
    @Column(columnDefinition = "serial")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 20)
    private String name;

    @Column(nullable = false, length = 64)
    private String description;

    @ManyToMany
    private List<Employee> listOfEmployees;

    @OneToMany(mappedBy = "project", orphanRemoval = true)
    private List<Task> listOfTasks;

    @ManyToOne
    @JoinColumn(name = "id_company")
    private Company company;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Employee> getListOfEmployees() {
        return listOfEmployees;
    }

    public void setListOfEmployees(List<Employee> listOfEmployees) {
        this.listOfEmployees = listOfEmployees;
    }

    public List<Task> getListOfTasks() {
        return listOfTasks;
    }

    public void setListOfTasks(List<Task> listOfTasks) {
        this.listOfTasks = listOfTasks;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
