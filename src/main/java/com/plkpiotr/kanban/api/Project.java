package com.plkpiotr.kanban.api;

import javax.persistence.*;
import java.util.ArrayList;

/**
 * Represents a project in a company.
 * A project can have many tasks.
 */
@Entity
@Table(name = "Projects")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "company")
    private String company;

    @OneToMany(mappedBy = "idProject", fetch = FetchType.EAGER)
    private ArrayList<Task> tasks;

    public int getId() {
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

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
