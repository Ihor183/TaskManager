package com.tern.test.taskmanager.domain;

import org.bson.types.ObjectId;

import java.util.Objects;

public class Task {
    private String id = ObjectId.get().toString();
    private String task;
    private Boolean isCompleted;
    private Boolean isDeleted;

    public Task() {
        this.isCompleted = false;
        this.isDeleted = false;
    }

    public Task(String task) {
        this.task = task;
        this.isCompleted = false;
        this.isDeleted = false;
    }

    public Task(String id, String task, Boolean isCompleted, Boolean isDeleted) {
        this.id = id;
        this.task = task;
        this.isCompleted = isCompleted;
        this.isDeleted = isDeleted;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public Boolean getCompleted() {
        return isCompleted;
    }

    public void setCompleted(Boolean completed) {
        this.isCompleted = completed;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task1 = (Task) o;
        return task.equals(task1.task);
    }

    @Override
    public int hashCode() {
        return Objects.hash(task);
    }

    @Override
    public String toString() {
        return "Task{" +
                "id='" + id + '\'' +
                ", task='" + task + '\'' +
                ", isCompleted=" + isCompleted +
                '}';
    }
}
