package com.tern.test.taskmanager.domain;

import java.util.Objects;

public class IncomingTask {
    private String id;
    private String task;
    private String fromUserEmail;
    private String message;

    public IncomingTask(String id, String task, String fromUserEmail, String message) {
        this.id = id;
        this.task = task;
        this.fromUserEmail = fromUserEmail;
        this.message = message;
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

    public String getFromUserEmail() {
        return fromUserEmail;
    }

    public void setFromUserEmail(String fromUserEmail) {
        this.fromUserEmail = fromUserEmail;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IncomingTask that = (IncomingTask) o;
        return task.equals(that.task) &&
                fromUserEmail.equals(that.fromUserEmail) &&
                Objects.equals(message, that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(task, fromUserEmail, message);
    }

    @Override
    public String toString() {
        return "IncomingTask{" +
                "id='" + id + '\'' +
                ", task='" + task + '\'' +
                ", fromUserEmail='" + fromUserEmail + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
