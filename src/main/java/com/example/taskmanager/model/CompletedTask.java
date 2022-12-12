package com.example.taskmanager.model;



import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name="completed_tasks")
public class CompletedTask {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column
    private int id;

    @Column
    private int taskId;

    @Column
    private Date completionDate;

    @Column
    private int completedBy;

    // getters and setters for the properties

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public Date getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(Date completionDate) {
        this.completionDate = completionDate;
    }

    public int getCompletedBy() {
        return completedBy;
    }

    public void setCompletedBy(int completedBy) {
        this.completedBy = completedBy;
    }

    @Override
    public String toString() {
        return "CompletedTask{" +
                "id=" + id +
                ", taskId=" + taskId +
                ", completionDate=" + completionDate +
                ", completedBy=" + completedBy +
                '}';
    }
}
