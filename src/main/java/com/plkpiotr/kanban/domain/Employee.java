package com.plkpiotr.kanban.domain;

import javax.persistence.*;
import java.util.List;

/**
 * Represents a employee.
 * A employee belongs to a company, it can have many tasks and many projects.
 */
@Entity
@Table(name = "employees")
public class Employee  {

    @Id
    @Column(columnDefinition = "serial")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 15)
    private String name;

    @Column(nullable = false, length = 20)
    private String surname;

    @Column(nullable = false, length = 10)
    private String nick;

    @Column(nullable = false, length = 64)
    private String password;

    @Column(nullable = false, length = 15)
    private String avatar;

    @ManyToMany(mappedBy = "listOfEmployees")
    private List<Project> listOfProjects;

    @OneToMany(mappedBy = "employee")
    private List<Task> listOfTask;

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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public List<Project> getListOfProjects() {
        return listOfProjects;
    }

    public void setListOfProjects(List<Project> listOfProjects) {
        this.listOfProjects = listOfProjects;
    }

    public List<Task> getListOfTask() {
        return listOfTask;
    }

    public void setListOfTask(List<Task> listOfTask) {
        this.listOfTask = listOfTask;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
