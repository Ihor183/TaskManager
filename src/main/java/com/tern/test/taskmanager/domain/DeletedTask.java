package com.tern.test.taskmanager.domain;

import org.bson.types.ObjectId;

import java.util.Date;
import java.util.Objects;

public class DeletedTask {
    private String id = ObjectId.get().toString();
    private Task task;
    private Date date;

    public DeletedTask() {   }

    public DeletedTask(Task task) {
        this.task = task;
        this.date = new Date();
    }

    public DeletedTask(String id, Task task, Date date) {
        this.id = id;
        this.task = task;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeletedTask that = (DeletedTask) o;
        return task.equals(that.task) &&
                date.equals(that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(task, date);
    }

    @Override
    public String toString() {
        return "DeletedTask{" +
                "id='" + id + '\'' +
                ", task=" + task +
                ", date=" + date +
                '}';
    }
}
