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
}
