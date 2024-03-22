package com.onedayoffer.taskdistribution.repositories.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String fio;

    @Column(nullable = false)
    private String jobTitle;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name = "employee_id")
    private List<Task> tasks = new ArrayList<>();

    public void addTask(Task task) {
        this.tasks.add(task);
        task.setEmployee(this);
    }

    public List<Task> getTasks() {
        return tasks;
    }
}
