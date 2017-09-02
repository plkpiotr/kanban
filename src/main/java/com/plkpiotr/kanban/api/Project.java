package com.plkpiotr.kanban.api;

import javax.persistence.*;
import java.util.List;

/**
 * Represents a project.
 * A project belongs to a company, can have many employees and many tasks.
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

    @Column(nullable = false, length = 6)
    private String color;

    @ManyToMany
    private List<Employee> listOfEmployees;

    @OneToMany(mappedBy = "project")
    private List<Task> listOfTasks;

    @ManyToOne
    @JoinColumn(name = "id_company")
    private Company company;

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
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

    public List<Employee> getListOfEmployees() {
        return listOfEmployees;
    }

    public void setListOfEmployees(List<Employee> listOfEmployees) {
        this.listOfEmployees = listOfEmployees;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
