package com.plkpiotr.kanban.api;

import javax.persistence.*;

/**
 * Represents a task in a project.
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Employee getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(Employee idEmployee) {
        this.idEmployee = idEmployee;
    }

    public Project getIdProject() {
        return idProject;
    }

    public void setIdProject(Project idProject) {
        this.idProject = idProject;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
