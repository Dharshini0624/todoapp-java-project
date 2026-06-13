package com.todo.todoapp.model; //model package

import jakarta.persistence.*; //this import is used for database mapping

@Entity // this class represents a database table
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto generated primary key
    private Long id;

    private String title; //task title
    private String description; //task description
    private boolean completed; //task status (true/false)

    public Task() {//default constructor for jpa
    }
    //getters and setters to access data
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}

