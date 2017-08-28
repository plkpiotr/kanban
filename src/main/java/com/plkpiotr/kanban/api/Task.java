package com.plkpiotr.kanban.api;

import javax.persistence.*;

/**
 * Represents a task in a projects
 */
@Entity
@Table(name = "Tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "idEmployee")
    @ManyToOne
    @JoinColumn(name = "idEmployee")
    private Employee idEmployee;

    @Column(name = "idProject")
    @ManyToOne
    @JoinColumn(name = "idProject")
    private Project idProject;

    @Column(name = "category")
    private String category;

    @Lob
    @Column(name = "content")
    private String content;

}
