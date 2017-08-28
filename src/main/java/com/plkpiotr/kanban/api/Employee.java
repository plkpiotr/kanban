package com.plkpiotr.kanban.api;

import javax.persistence.*;
import java.util.ArrayList;

/**
 * Represents a employee in a team of programmers
 * A employee can be enrolled in many projects and add a lot of task to them
 */
@Entity
@Table(name = "Employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "nick")
    private String nick;

    @Column(name = "password")
    private String password;

    @Column(name = "sex")
    private String sex;

    @Column(name = "company")
    private String company;

    @Column(name = "avatar")
    private String avatar;

    @OneToMany(mappedBy = "idEmployee", fetch = FetchType.EAGER)
    private ArrayList<Task> projects;
}
