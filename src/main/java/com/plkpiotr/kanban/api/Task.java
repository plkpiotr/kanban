package com.plkpiotr.kanban.api;

import javax.persistence.*;

/**
 * Represents a task in a projects
 * A project can have many tasks
 */
@Entity
@Table(name = "Tasks")
public class Task {
    @Id
    @GeneratedValue
    private int id;

    @Column(name = "idEmployee")
    private String idEmployee;

    @Column(name = "idProject")
    private String idProject;

    @Column(name = "category")
    private String category;

    @Column(name = "content")
    private String content;
}
