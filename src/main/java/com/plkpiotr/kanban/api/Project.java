package com.plkpiotr.kanban.api;

import javax.persistence.*;
import java.util.List;

/**
 * Represents a project in a company.
 * A project can have many tasks.
 */
@Entity
@Table(name = "projects")
public class Project {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false, length = 15)
    private String name;

    @Column(nullable = false, length = 64)
    private String description;

    @Column(nullable = false, length = 15)
    private String company;

    @ManyToMany
    private List<Employee> listOfEmployees;

    @OneToMany(mappedBy = "project")
    private List<Task> listOfTasks;

    public long getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public List<Employee> getListOfEmployee() {
        return listOfEmployees;
    }

    public void setListOfEmployee(List<Employee> listOfEmployee) {
        this.listOfEmployees = listOfEmployee;
    }

    public List<Task> getListOfTasks() {
        return listOfTasks;
    }

    public void setListOfTasks(List<Task> listOfTasks) {
        this.listOfTasks = listOfTasks;
    }
}
