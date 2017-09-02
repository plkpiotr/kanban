package com.plkpiotr.kanban.api;

import javax.persistence.*;

/**
 * Represents a tasks.
 * A tasks belongs to a project and employee.
 */
@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false, length = 5)
    private String category;

    @Column(nullable = false, length = 64)
    private String content;

    @ManyToOne
    @JoinColumn(name = "id_project")
    private Project project;

    @ManyToOne
    @JoinColumn(name = "id_employee")
    private Employee employee;

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
