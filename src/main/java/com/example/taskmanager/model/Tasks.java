package com.example.taskmanager.model;

import jakarta.persistence.*;

import java.sql.Date;
@Entity
@Table(name="tasks")
public class Tasks {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column
    private int id;

    @Column
    private int userId;

    @Column
    private String name;

    @Column
    private Date dueDate;

    @Column
    private String priority;

    @Column
    private boolean completed;

    @Column
    private String notes;

    @Column
    private String attachments;

    // getters and setters for the properties


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getAttachments() {
        return attachments;
    }

    public void setAttachments(String attachments) {
        this.attachments = attachments;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", userId=" + userId +
                ", name='" + name + '\'' +
                ", dueDate=" + dueDate +
                ", priority='" + priority + '\'' +
                ", completed=" + completed +
                ", notes='" + notes + '\'' +
                ", attachments='" + attachments + '\'' +
                '}';
    }
}