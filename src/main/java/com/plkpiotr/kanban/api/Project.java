package com.plkpiotr.kanban.api;

import javax.persistence.*;

/**
 * Represents a project in a company
 * A project can have many tasks
 */
@Entity
@Table(name = "Projects")
public class Project {
    @Id
    @GeneratedValue
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "company")
    private String company;
}
